package base;

public class Escalonador {
	
	private Processo[] processos;
	protected double tempoMedioEspera;
	protected double tempoMedioSaida;
	
	public Escalonador(Processo[] processos) {
		Processo[] copia = new Processo[processos.length];
		for(int i = 0; i < processos.length; i++) {
			copia[i] = processos[i];
		}
		this.setProcessos(copia);
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
	
	public Processo[]getProcessos() {
		return this.processos;
	}
	public void setProcessos(Processo[] processos) {
		this.processos = processos;
	}
}
