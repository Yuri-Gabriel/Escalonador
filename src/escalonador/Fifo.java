package escalonador;

import base.Escalonador;
import base.Processo;
import base.StatusProcesso;

public class Fifo extends Escalonador {

  public Fifo(Processo[] processos) {
    super(processos);
    this.setTempoMedioSaida();
    this.setTempoMedioEspera();
    for(Processo p : this.getProcessos()) {
      p.setStatus(StatusProcesso.PRONTO);
    }
  }
}
