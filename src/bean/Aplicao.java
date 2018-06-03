package bean;

import java.util.Date;

public class Aplicao {
	private int id ;
	private int idTarefa;
	private int idUsuario;
	private String texto;
	private Date dataDeAplicao;
	private String observacoes;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdTarefa() {
		return idTarefa;
	}
	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getDataDeAplicao() {
		return dataDeAplicao;
	}
	public void setDataDeAplicao(Date dataDeAplicao) {
		this.dataDeAplicao = dataDeAplicao;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}
