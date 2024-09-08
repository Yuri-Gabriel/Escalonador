package escalonador;

import base.Escalonador;
import base.Processo;

public class Fifo extends Escalonador {

	public Fifo(Processo[] processos) {
		super(processos);
	}
	
	public void start() {
		System.out.println(this.getTempoMedioEspera());
	}

	@Override
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

	@Override
	public void setTempoMedioEspera() {
		double total = 0;
		for(int i = 0; i < this.getProcessos().length; i++) {
			for(int j = 0; j < i; j++) {
				total += this.getProcessos()[j].getSurto();
			}
		}
		this.tempoMedioEspera = total / this.getProcessos().length;
	}
	
	
}
