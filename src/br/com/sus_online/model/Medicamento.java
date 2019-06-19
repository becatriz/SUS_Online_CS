package br.com.sus_online.model;

public class Medicamento {
	
	
	int id_medicacao;
	String nomeMedicacao;
	String dosagem;
	String contra_ind;
	String posologia;
	int idUsuario;
	
	
	
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	
	public int getId_medicacao() {
		return id_medicacao;
	}
	public void setId_medicacao(int id_medicacao) {
		this.id_medicacao = id_medicacao;
	}
	public String getNomeMedicacao() {
		return nomeMedicacao;
	}
	public void setNomeMedicacao(String nomeMedicacao) {
		this.nomeMedicacao = nomeMedicacao;
	}
	public String getDosagem() {
		return dosagem;
	}
	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}
	public String getContra_ind() {
		return contra_ind;
	}
	public void setContra_ind(String contra_ind) {
		this.contra_ind = contra_ind;
	}
	public String getPosologia() {
		return posologia;
	}
	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}
	
	
	
	

}
