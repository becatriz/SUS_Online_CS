package br.com.sus_online.model;

public class AgendaExame extends Autentica_Usuario {
	
	String data;
	String hora;
	String exame;
	String estado;
	String cidade;
	String ubs;
	int IdUsuario;
	
	
	
	public AgendaExame() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getExame() {
		return exame;
	}
	public void setExame(String exame) {
		this.exame = exame;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUbs() {
		return ubs;
	}
	public void setUbs(String ubs) {
		this.ubs = ubs;
	}
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	
	
	
	

}
