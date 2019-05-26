package br.com.sus_online.model;

;

public class AgendaConsulta extends Autentica_Usuario {
	
	


	String data;
	String hora;
	String cidade;
	String estado;
	String ubs;
	String medico;
	String especialidade;
	int idUsuario;

	




	public AgendaConsulta() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getIdUsuario() {
		return idUsuario;
	}





	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}





	@Override
	public void setid(int id) {
		// TODO Auto-generated method stub
		super.setid(id);
	}





	@Override
	public String getUsuario() {
		// TODO Auto-generated method stub
		return super.getUsuario();
	}





	@Override
	public void setUsuario(String usuario) {
		// TODO Auto-generated method stub
		super.setUsuario(usuario);
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUbs() {
		return ubs;
	}

	public void setUbs(String ubs) {
		this.ubs = ubs;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

}
