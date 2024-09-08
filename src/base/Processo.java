package base;

public class Processo {
	
	private String name;
	private StatusProcesso status;
	private int surto;
	
	public Processo(String nome, int surto) {
		this.setName(nome);
		this.setStatus(StatusProcesso.INICIANDO);
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
}
