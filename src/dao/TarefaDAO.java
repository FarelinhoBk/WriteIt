package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Tarefa;

public class TarefaDAO extends GenericDao<Tarefa>{
	//Inclus�o
	private static String insert = "INSERT INTO WRITEIT.TAREFA( NOME, IDCRIADOR, DESCRICAO, DATALIMITE, SITUACAO, VALOR) VALUES (?,?,?,?,?,?);";
	//Altera��o
	private static String update = "UPDATE WRITEIT.TAREFA " +
			"SET NOME = ?, IDCRIADOR = ?, DESCRICAO = ?, DATALIMITE = ?, SITUACAO = ?, VALOR = ?" +
			" WHERE ID = ?";
	//Dele��o
	private static String delete = "DELETE FROM WRITEIT.TAREFA WHERE id = ?";
	//Leitura
	private static String ler = "SELECT * FROM WRITEIT.TAREFA WHERE id = ?";
	//Leitura
	private static String lerAll = "SELECT * FROM WRITEIT.TAREFA";

	@Override
	public void incluir(Tarefa tarefa) throws SQLException {
		try {
			insert(insert,
					tarefa.getNome(),
					tarefa.getIdCriador(),
					tarefa.getDescricao(),
					tarefa.getDataLimite(),
					tarefa.getSituacao(),
					tarefa.getValor());
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
			// TODO: handle exception
		}
	}

	@Override
	public void alterar(Tarefa tarefa) throws SQLException {
		try {
			update(update,
					tarefa.getId(),
					tarefa.getNome(),
					tarefa.getIdCriador(),
					tarefa.getDescricao(),
					tarefa.getDataLimite(),
					tarefa.getSituacao(),
					tarefa.getValor());
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
			// TODO: handle exception
		}
	}

	@Override
	public Tarefa ler(int codigo) throws SQLException {
		ResultSet res=null;
		// Faz a select
		try {
			res = select(ler, codigo);
			//Le o registro
			res.next();
			//Seta os dados
			Tarefa tarefa = new Tarefa();
			tarefa.setId(res.getInt("Id"));
			tarefa.setNome(res.getString("Nome"));
			tarefa.setIdCriador(res.getInt("IdCriador"));
			tarefa.setDescricao(res.getString("Descricao"));
			tarefa.setDataLimite(res.getDate("DataLimite"));
			tarefa.setSituacao(res.getInt("Situacao"));
			tarefa.setValor(res.getDouble("Valor"));
			return tarefa;
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			res.close();
		}
	}

	@Override
	public List<Tarefa> findAll() throws SQLException {
		ResultSet res=null;
		List<Tarefa> resultado = new ArrayList<>();
		// Faz a select
		try {
			res = select(lerAll);
			while(res.next()) {
				//Le a tarefa
				Tarefa tarefa =  new Tarefa();
				tarefa.setId(res.getInt("Id"));
				tarefa.setNome(res.getString("Nome"));
				tarefa.setIdCriador(res.getInt("IdCriador"));
				tarefa.setDescricao(res.getString("Descricao"));
				tarefa.setDataLimite(res.getDate("DataLimite"));
				tarefa.setSituacao(res.getInt("Situacao"));
				tarefa.setValor(res.getDouble("Valor"));
				resultado.add(tarefa);
			}
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			//fecha
			res.close();
		}
		// TODO Auto-generated method stub
		return resultado;
	}

	@Override
	public void excluir(int codigo) throws SQLException {
		try {
			delete(delete, codigo);
		} catch (Exception e) {
			// TODO: handle exception
			throw new SQLException(e.getMessage());
		}
	}
}
