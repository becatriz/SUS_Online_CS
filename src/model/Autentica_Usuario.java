package model;

public class Autentica_Usuario {
	
	int id;
	String nome;
	String usuario;
	String senha;
	
	/*public Autentica_Usuario(int id, String usuario, String senha) {
		super();
		this.id=id;
		this.usuario = usuario;
		this.senha = senha;
	}
	*/
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setid(int id) {
		this.id=id;
		
	}
		
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
