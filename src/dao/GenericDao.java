package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.Conexao;
import db.ConnectionPool;


public abstract class GenericDao<T>{
	private Conexao con;

	public Connection getConnection() throws SQLException{
		// carrega a conexao
		this.con= ConnectionPool.getConexao();
		return con.getConnection();
	}

	public void closeConnection() {
		// Libera a conexao
		this.con.libera();
		this.con=null;
	}

	public void insert(String insertSql, Object... parametros) throws SQLException {
		//Prepara o comando sql
		PreparedStatement pstmt = getConnection().prepareStatement(insertSql);
		//Carrega os par�metros
		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i+1, parametros[i]);
		}
		//executa e fecha
		pstmt.executeUpdate();
		this.closeConnection();
	}

	public void update(String updateSql, Object id, Object... parametros) throws SQLException {
		//Prepara o comando sql
		PreparedStatement pstmt = getConnection().prepareStatement(updateSql);
		//carrega os par�metros
		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i+1, parametros[i]);
		}
		//carrega o id
		pstmt.setObject(parametros.length + 1, id);
		//executa e fecha
		pstmt.executeUpdate();
		this.closeConnection();
	}

	public ResultSet select(String selectSql, Object... parametros) throws SQLException {
		//Prepara o comando sql
		PreparedStatement pstmt = getConnection().prepareStatement(selectSql);

		//carrega os par�metros
		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i+1, parametros[i]);
		}
		ResultSet res = pstmt.executeQuery();
		this.closeConnection();
		return res;
	}

	public void delete(String deleteSql, Object... parametros) throws SQLException {
		//Prepara o comando sql
		PreparedStatement pstmt = getConnection().prepareStatement(deleteSql);

		//carrega os par�metros
		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i+1, parametros[i]);
		}

		//executa e fecha
		pstmt.executeUpdate();
		this.closeConnection();
	}

	//Metodos que devem ser implementados
	public abstract void incluir(T bean) throws SQLException;

	public abstract void alterar(T bean) throws SQLException;

	public abstract T ler(int codigo) throws SQLException;

	public abstract List<T> findAll() throws SQLException;

	public abstract void excluir(int codigo) throws SQLException;
}
