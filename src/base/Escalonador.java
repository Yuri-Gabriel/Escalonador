package base;

public abstract class Escalonador {
	
	private Processo[] processos;
	protected double tempoMedioEspera;
	protected double tempoMedioSaida;
	
	public Escalonador(Processo[] processos) {
		this.setProcessos(processos);
		this.setTempoMedioSaida();
		this.setTempoMedioEspera();
	}
	
	
	public double getTempoMedioSaida() {
		return this.tempoMedioSaida;
	}
	
	public abstract void setTempoMedioSaida();
	
	public double getTempoMedioEspera() {
		return this.tempoMedioEspera;
	}
	
	public abstract void setTempoMedioEspera();
	
	public Processo[]getProcessos() {
		return this.processos;
	}
	public void setProcessos(Processo[] processos) {
		this.processos = processos;
	}
}
