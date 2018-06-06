package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Aplicao;
import bean.Tarefa;
import bean.Usuario;
import dao.AplicaoDAO;
import dao.TarefaDAO;

@WebServlet("/Deletar")
public class Deletar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Busca entidade
		String entidade = req.getParameter("entidade");
		if(entidade==null)throw new ServletException("Sem entidade");
		//Busca id
		if(req.getParameter("id")==null)throw new ServletException("Sem ID");
		int id = Integer.parseInt(req.getParameter("id"));
		// Busca o usuario
		Usuario usu = (Usuario) req.getSession().getAttribute("user");
		if(usu==null) {
			resp.sendRedirect("login");
			return;
		}
		switch (entidade) {
		case "tarefa":
			try {
				Tarefa t = new TarefaDAO().ler(id);
				if(t.getIdCriador()!=usu.getId()) throw new ServletException("Somente o usuario criador pode deletar esse registro");
				new TarefaDAO().excluir(id);
			} catch (SQLException e) {
				throw new ServletException("Não conseguiu deletar : " + e.getMessage());
			}
			break;
		case "aplicacao":
			try {
				Aplicao t = new AplicaoDAO().ler(id);
				if(t.getIdUsuario()!=usu.getId()) throw new ServletException("Somente o usuario criador pode deletar esse registro");
				new AplicaoDAO().excluir(id);
			} catch (SQLException e) {
				throw new ServletException("Não conseguiu deletar : " + e.getMessage());
			}
			break;
		default:
			throw new ServletException("Entidade inválida");
		} 
		resp.sendRedirect("tarefalist.jsp");
	}
}