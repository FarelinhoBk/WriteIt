package bean;

public class Usuario {
	private int id;
	private int tipoDeUsuario;
	private String nome;
	private String telefone;
	private String email;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipoDeUsuario() {
		return tipoDeUsuario;
	}
	public void setTipoDeUsuario(int tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
