package base;

public abstract class Escalonador {

  private Processo[] processos;
  protected double tempoMedioEspera;
  protected double tempoMedioSaida;
   private int tempoTotalExecucao;

  public Escalonador(Processo[] processos) {
    Processo[] copia = new Processo[processos.length];
    for(Processo p : copia) {
      p = new Processo();
    }
    for(int i = 0; i < processos.length; i++) {
      copia[i] = new Processo(processos[i].getName(), processos[i].getChegada(), processos[i].getSurto());
    }
    this.setProcessos(copia);
    this.setTempoTotalExecucao();
  }

  public void start() {
    Processo atual = new Processo();
    for(int i = 0; i < this.getProcessos().length; i++) {
      if(this.getProcessos()[i].getStatus() == StatusProcesso.PRONTO) {
        atual = this.getProcessos()[i];
        atual.setStatus(StatusProcesso.EXECUTANDO);
        while(atual.getSurto() > 0) {
          atual.setSurto(atual.getSurto() - 1);
        }
        atual.setStatus(StatusProcesso.FINALIZADO);
      }
    }
  }

  public double getTempoMedioSaida() {
    return this.tempoMedioSaida;
  }

  public void setTempoMedioSaida() {
    double total = 0;
    double tempoParaFinalizar = 0;
    for(int i = 0; i < this.getProcessos().length; i++) {
      for(int j = 0; j <= i; j++) {
        tempoParaFinalizar += this.getProcessos()[j].getSurto();
      }
      total += tempoParaFinalizar;
      tempoParaFinalizar = 0;
    }
    this.tempoMedioSaida = total / this.getProcessos().length;
  }

  public double getTempoMedioEspera() {
    return this.tempoMedioEspera;
  }

  public void setTempoMedioEspera() {
    double total = 0;
    for(int i = 0; i < this.getProcessos().length; i++) {
      for(int j = 0; j < i; j++) {
        total += this.getProcessos()[j].getSurto();
      }
    }
    this.tempoMedioEspera = total / this.getProcessos().length;
  }

  public Processo[] getProcessos() {
    return this.processos;
  }
  public void setProcessos(Processo[] processos) {
    this.processos = processos;
  }

  public int getTempoTotalExecucao() {
    return this.tempoTotalExecucao;
  }

  private void setTempoTotalExecucao() {
    int tempo = 0;
    for(Processo p : this.getProcessos()) {
      tempo += p.getSurto();
    }
    this.tempoTotalExecucao = tempo;
  }
}
