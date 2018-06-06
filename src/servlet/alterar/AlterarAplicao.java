package servlet.alterar;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Aplicao;
import bean.Usuario;
import dao.AplicaoDAO;

@WebServlet("/Alterar/aplicacao")
public class AlterarAplicao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Busca id
		if(req.getParameter("id")==null)throw new ServletException("Sem ID");
		int id = Integer.parseInt(req.getParameter("id"));

		// Busca o usuario
		Usuario usu = (Usuario) req.getSession().getAttribute("user");
		if(usu==null) {
			resp.sendRedirect("login");
			return;
		}
		//Verifica se a aplicac�o � do funcion�rio
		try {
			// L� a aplica��o do banco e valida se o ID � igual ao do funcion�rio atual
			if(new AplicaoDAO().ler(id).getIdUsuario()!=usu.getId()) {
				throw new ServletException("Somente o usuario criador pode alterar esse registro");
			}
		} catch (SQLException e) {
			throw new ServletException("Aplica��o n�o existe");
		}
		//Carrega os dados da aplicac�o
		Aplicao a = new Aplicao();
		a.setId(id);
		a.setIdTarefa(Integer.parseInt(req.getParameter("idTarefa")));
		a.setTexto(req.getParameter("texto"));
		a.setObservacoes(req.getParameter("observacoes"));
		//Tenta alterar
		try {
			new AplicaoDAO().alterar(a);
			resp.sendRedirect("tarefalist.jsp");
			return;
		} catch (Exception e) {
			throw new ServletException("Nao conseguiu alterar:" + e.getMessage());
		}
	}
}
