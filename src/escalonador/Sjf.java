package escalonador;

import base.Escalonador;
import base.Processo;

public class Sjf extends Escalonador{
	
	public Sjf(Processo[] processos) {
		super(processos);
		this.ordenarProcessos();
		this.setTempoMedioSaida();
		this.setTempoMedioEspera();
		System.out.println("SJF");
		System.out.println(this.getTempoMedioEspera());
		System.out.println(this.getTempoMedioSaida());
	}
	
	private void ordenarProcessos() {
		Processo backup = null;
		int i = 0;
		while(i < this.getProcessos().length - 1) {
			if(this.getProcessos()[i].getSurto() > this.getProcessos()[i + 1].getSurto()) {
				backup = this.getProcessos()[i];
				this.getProcessos()[i] = this.getProcessos()[i + 1];
				this.getProcessos()[i + 1] = backup;
				
				i = 0;
			} else {
				i++;
			}
		}
	}
}
