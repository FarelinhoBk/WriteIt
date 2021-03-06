package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Aplicao;

public class AplicaoDAO extends GenericDao<Aplicao>{
	//Inclus�o
	private static String insert = "INSERT INTO WRITEIT.APLICACAO( IDTAREFA, IDUSUARIO, TEXTO, DATADEAPLICAO, OBSERVACOES) VALUES (?,?,?,?,?);";
	//Altera��o
	private static String update = "UPDATE WRITEIT.APLICACAO " +
			" SET IDTAREFA = ?, TEXTO = ?, OBSERVACOES = ?"+
			" WHERE ID = ?";
	//Dele��o
	private static String delete = "DELETE FROM WRITEIT.APLICACAO WHERE id = ?";
	//Leitura
	private static String ler = "SELECT * FROM WRITEIT.APLICACAO WHERE id = ?";
	//Leitura
	private static String lerTarefa = "SELECT * FROM WRITEIT.APLICACAO WHERE idtarefa = ?";
	//Leitura
	private static String lerAll = "SELECT * FROM WRITEIT.APLICACAO";

	@Override
	public void incluir(Aplicao aplicao) throws SQLException {
		try {
			insert(insert,
					aplicao.getIdTarefa(),
					aplicao.getIdUsuario(),
					aplicao.getTexto(),
					aplicao.getDataDeAplicao(),
					aplicao.getObservacoes());
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
	}

	@Override
	public void alterar(Aplicao aplicao) throws SQLException {
		try {
			update(update,
					aplicao.getId(),
					aplicao.getIdTarefa(),
					aplicao.getTexto(),
					aplicao.getObservacoes());
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
	}

	@Override
	public Aplicao ler(int codigo) throws SQLException {
		ResultSet res=null;
		// Faz a select
		try {
			res = select(ler, codigo);
			//Le o registro
			res.next();
			//Seta os dados
			Aplicao aplicao = new Aplicao();
			aplicao.setId(res.getInt("Id"));
			aplicao.setIdTarefa(res.getInt("IdTarefa"));
			aplicao.setIdUsuario(res.getInt("IdUsuario"));
			aplicao.setTexto(res.getString("Texto"));
			aplicao.setDataDeAplicao(res.getDate("DataDeAplicao"));
			aplicao.setObservacoes(res.getString("Observacoes"));
			return aplicao;
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			res.close();
		}
	}

	//Ler por tarefa
	public List<Aplicao> lerPorTarefa(int IdTarefa) throws SQLException {
		ResultSet res=null;
		List<Aplicao> resultado = new ArrayList<>();
		// Faz a select
		try {
			res = select(lerTarefa, IdTarefa);
			while(res.next()) {
				//Le a aplicao
				Aplicao aplicao =  new Aplicao();
				aplicao.setId(res.getInt("Id"));
				aplicao.setIdTarefa(res.getInt("IdTarefa"));
				aplicao.setIdUsuario(res.getInt("IdUsuario"));
				aplicao.setTexto(res.getString("Texto"));
				aplicao.setDataDeAplicao(res.getDate("DataDeAplicao"));
				aplicao.setObservacoes(res.getString("Observacoes"));
				resultado.add(aplicao);
			}
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			res.close();
		}
		return resultado;
	}

	@Override
	public List<Aplicao> findAll() throws SQLException {
		ResultSet res=null;
		List<Aplicao> resultado = new ArrayList<>();
		// Faz a select
		try {
			res = select(lerAll);
			while(res.next()) {
				//Le a aplicao
				Aplicao aplicao =  new Aplicao();
				aplicao.setId(res.getInt("Id"));
				aplicao.setIdTarefa(res.getInt("IdTarefa"));
				aplicao.setIdUsuario(res.getInt("IdUsuario"));
				aplicao.setTexto(res.getString("Texto"));
				aplicao.setDataDeAplicao(res.getDate("DataDeAplicao"));
				aplicao.setObservacoes(res.getString("Observacoes"));
				resultado.add(aplicao);
			}
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			//fecha
			res.close();
		}
		return resultado;
	}

	@Override
	public void excluir(int codigo) throws SQLException {
		try {
			delete(delete, codigo);
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
	}
}
