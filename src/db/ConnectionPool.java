package db;

import java.sql.SQLException;
import java.util.ArrayList;


public class ConnectionPool {
	private static ConnectionPool self;
	//
	private static ArrayList<Conexao> conexoes;
	//Quantidade inciial de cone√ßoes
	public static final int qtdInicialConnection = 10;

	private ConnectionPool() {
		//Incializa o list
		conexoes = new ArrayList<>();
		//Adiciona rotina para finalizar as conexoes ao finalizar 
		Runtime.getRuntime().addShutdownHook(new onClose());
		// Cria as conexıes
		for (int i = 0; i < qtdInicialConnection; i++)conexoes.add(new Conexao());


	}

	public static synchronized Conexao getConexao() throws SQLException {
		//Se n√£o criou o pool ainda
		if(self==null) self = new ConnectionPool();
		Conexao con = buscaConexaoLivre();
		con.reserva();
		return con;
	}

	//Busca uma conexao livre e cria se nao encontrar
	private static Conexao buscaConexaoLivre() {
		//Percorre as conexıes buscando uma livre
		for (Conexao con : conexoes) {
			if(con.isLivre())return con;
		}
		//Se n„o encontrou cria uma nova conex„o
		Conexao con = new Conexao();
		conexoes.add(con);
		return con;
	}


	// Classe pra finalizar as conexoes
	static class onClose extends Thread {
		@Override
		public void run() {
			for (Conexao con : conexoes) {
				try {
					con.getConnection().close();
				} catch (Exception e) {}
			}
		}
	}
}
