package db;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {
	private Connection con;
	private Boolean livre;

	public Conexao() {
		//Indica que a conex√£o est√° livre
		this.livre=true;
		//Carrega uma conex√£o nova
		con = ConnectionDB.getConnection();
	}

	public Boolean isLivre() {
		return livre;
	}

	// Reserva e retorna a conex„o
	public Connection getConnection() throws SQLException{
		return con;
	}

	// Reserva a conex„o
	public void reserva() throws SQLException{
		if (!this.livre)throw new SQLException("Conexao ja esta sendo usada.");
		this.livre=false;
	}


	public void libera(){
		this.livre=true;
	}
}
