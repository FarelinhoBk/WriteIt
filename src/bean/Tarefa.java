package bean;

import java.util.Date;

public class Tarefa {
	private int id;
	private String nome;
	private int idCriador;
	private String descricao;
	private Date dataLimite;
	private int situacao;
	private double valor;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdCriador() {
		return idCriador;
	}
	public void setIdCriador(int idCriador) {
		this.idCriador = idCriador;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataLimite() {
		return dataLimite;
	}
	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao) {
		if(situacao==0) {
			this.situacao = 1;
		} else {
				this.situacao = situacao;
		}

	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
};
