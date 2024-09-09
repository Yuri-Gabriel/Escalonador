package base;

public class Processo {
	
	private String name;
	private StatusProcesso status;
	private int chegada;
	private int surto;
	
	public Processo(String nome, int chegada, int surto) {
		this.setName(nome);
		this.setStatus(StatusProcesso.INICIANDO);
		this.setChegada(chegada);
		this.setSurto(surto);
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StatusProcesso getStatus() {
		return this.status;
	}
	public void setStatus(StatusProcesso iniciando) {
		this.status = iniciando;
	}
	public int getSurto() {
		return this.surto;
	}
	public void setSurto(int tempoDeSurto) {
		this.surto = tempoDeSurto;
	}

	public int getChegada() {
		return chegada;
	}

	public void setChegada(int chegada) {
		this.chegada = chegada;
	}
}
