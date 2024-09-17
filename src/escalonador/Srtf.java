package escalonador;

import java.text.Format;
import java.util.concurrent.TimeUnit;

import base.Escalonador;
import base.Processo;
import base.StatusProcesso;

public class Strf extends Escalonador {

  public Strf(Processo[] processos) {
    super(processos);

  }

  public void start() {
    Processo atual = null;
    int tempoExecucao = 0;
    String text = "";
    String filaProntos = "";
    int surto = -1;
    do {
      this.setStatusForExecute(tempoExecucao);
      
      for(Processo p : this.getProcessos()) {
        System.out.println("Nome: " + p.getName());
        System.out.println("Status: " + p.getStatus());
        System.out.println("Surto: " + p.getSurto());
        surto = p.getSurto();
        if(p.getStatus() == StatusProcesso.PRONTO && !filaProntos.contains(p.getName())) {
          
          filaProntos += p.getName() + "(" + surto + "), ";
        }
      }
      text = String.format("| %d | %s |", new Integer(tempoExecucao), filaProntos == "" ? "-" : filaProntos);
      System.out.println(text);
      atual = this.getNextProcessForExecute();
       System.out.println("---Atual: " + atual.getName() + "(" + atual.getSurto() + "), ");
      atual.setSurto(atual.getSurto() - 1);

      if(atual.getSurto() == 0) {
        atual.setStatus(StatusProcesso.FINALIZADO);
      }
      
      tempoExecucao++;
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch(InterruptedException err) {
        System.out.println(err.getMessage());
      }
      
    } while (tempoExecucao < this.getTempoTotalExecucao());
    for(Processo p : this.getProcessos()) {
      System.out.println("Nome: " + p.getName());
      System.out.println("Status: " + p.getStatus());
      if(p.getStatus() == StatusProcesso.PRONTO && !filaProntos.contains(p.getName())) {
        filaProntos += p.getName() + "(" + p.getSurto() + "), ";
      }
    }
  }

  private boolean checkIfAllProcessWereFinished() {
    int contFinalizados = 0;
    for (Processo p : this.getProcessos()) {
      if (p.getStatus() == StatusProcesso.FINALIZADO) {
        contFinalizados++;
      }
    }
    return contFinalizados == this.getProcessos().length;
  }

  private void setStatusForExecute(int tempoExecucao) {
    for (int i = 0; i < this.getProcessos().length; i++) {
      if (this.getProcessos()[i].getChegada() == tempoExecucao) {
        this.getProcessos()[i].setStatus(StatusProcesso.PRONTO);
      }
    }
    int contExecutando = 0;
    for (int i = 0; i < this.getProcessos().length; i++) {
      if (this.getProcessos()[i].getStatus() == StatusProcesso.EXECUTANDO) {
        contExecutando++;
      }
    }
    System.out.println(contExecutando);
  }

  private Processo getNextProcessForExecute() {
    int posMenorSurto = 0;
    for (int i = 0; i < this.getProcessos().length; i++) {
      if (this.getProcessos()[i].getSurto() > 0 && this.getProcessos()[i].getSurto() < this.getProcessos()[posMenorSurto].getSurto()
          && this.getProcessos()[i].getStatus() == StatusProcesso.PRONTO) {
        posMenorSurto = i;
        i = 0;
      }
    }
    this.getProcessos()[posMenorSurto].setStatus(StatusProcesso.EXECUTANDO);
    return this.getProcessos()[posMenorSurto];
  }
}
