package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Usuario;

public class UsuarioDAO extends GenericDao<Usuario>{
	//Inclus�o
	private static String insert = "INSERT INTO WRITEIT.USUARIO(ID, USERNAME, SENHA, TIPODEUSUARIO, NOME, TELEFONE, EMAIL) VALUES (?,?,?,?,?,?,?);";
	//Altera��o
	private static String update = "UPDATE WRITEIT.USUARIO " +
			"SET USERNAME = ?, SET SENHA = ?, SET TIPODEUSUARIO = ?, SET NOME = ?, SET TELEFONE = ?, SET EMAIL = ?"+
			" WHERE ID = ?";
	//Dele��o
	private static String delete = "DELETE FROM WRITEIT.USUARIO WHERE id = ?";
	//Leitura
	private static String ler = "SELECT * FROM WRITEIT.USUARIO WHERE id = ?";
	//Leitura
	private static String lerUsername = "SELECT * FROM WRITEIT.USUARIO WHERE USERNAME = ?";
	//Leitura
	private static String lerValid = "SELECT * FROM WRITEIT.USUARIO WHERE USERNAME = ? AND SENHA = ?";
	//Leitura
	private static String lerAll = "SELECT * FROM WRITEIT.USUARIO";

	@Override
	public void incluir(Usuario usuario) throws SQLException {
		try {
			insert(insert,
					usuario.getId(),
					usuario.getUsername(),
					usuario.getSenha(),
					usuario.getTipoDeUsuario(),
					usuario.getNome(),
					usuario.getTelefone(),
					usuario.getEmail());
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
			// TODO: handle exception
		}
	}

	@Override
	public void alterar(Usuario usuario) throws SQLException {
		try {
			update(update,
							usuario.getId(),
							usuario.getUsername(),
							usuario.getSenha(),
							usuario.getTipoDeUsuario(),
							usuario.getNome(),
							usuario.getTelefone(),
							usuario.getEmail());
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
			// TODO: handle exception
		}
	}

	@Override
	public Usuario ler(int codigo) throws SQLException {
		ResultSet res=null;
		// Faz a select
		try {
			res = select(ler, codigo);
			//Le o registro
			res.next();
			//Seta os dados
			Usuario usuario = new Usuario();
			usuario.setId(res.getInt("Id"));
			usuario.setUsername(res.getString("Username"));
			usuario.setSenha(res.getString("Senha"));
			usuario.setTipoDeUsuario(res.getInt("TipoDeUsuario"));
			usuario.setNome(res.getString("Nome"));
			usuario.setTelefone(res.getString("Telefone"));
			usuario.setEmail(res.getString("Email"));
			return usuario;
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			res.close();
		}
	}
	

	public Usuario lerPorUsername(String username) throws SQLException {
		ResultSet res=null;
		// Faz a select
		try {
			res = select(lerUsername, username);
			//Le o registro
			res.next();
			//Seta os dados
			Usuario usuario = new Usuario();
			usuario.setId(res.getInt("Id"));
			usuario.setUsername(res.getString("Username"));
			usuario.setSenha(res.getString("Senha"));
			usuario.setTipoDeUsuario(res.getInt("TipoDeUsuario"));
			usuario.setNome(res.getString("Nome"));
			usuario.setTelefone(res.getString("Telefone"));
			usuario.setEmail(res.getString("Email"));
			return usuario;
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			res.close();
		}
	}
	

	public Usuario lerValid(String username, String senha) throws SQLException {
		ResultSet res=null;
		// Faz a select
		try {
			res = select(lerValid, username, senha);
			//Le o registro
			res.next();
			//Seta os dados
			Usuario usuario = new Usuario();
			usuario.setId(res.getInt("Id"));
			usuario.setUsername(res.getString("Username"));
			usuario.setSenha(res.getString("Senha"));
			usuario.setTipoDeUsuario(res.getInt("TipoDeUsuario"));
			usuario.setNome(res.getString("Nome"));
			usuario.setTelefone(res.getString("Telefone"));
			usuario.setEmail(res.getString("Email"));
			return usuario;
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			res.close();
		}
	}

	@Override
	public List<Usuario> findAll() throws SQLException {
		ResultSet res=null;
		List<Usuario> resultado = new ArrayList<>();
		// Faz a select
		try {
			res = select(lerAll);
			while(res.next()) {
				//Le a usuario
				Usuario usuario = new Usuario();
				usuario.setId(res.getInt("Id"));
				usuario.setUsername(res.getString("Username"));
				usuario.setSenha(res.getString("Senha"));
				usuario.setTipoDeUsuario(res.getInt("TipoDeUsuario"));
				usuario.setNome(res.getString("Nome"));
				usuario.setTelefone(res.getString("Telefone"));
				usuario.setEmail(res.getString("Email"));
				resultado.add(usuario);
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
