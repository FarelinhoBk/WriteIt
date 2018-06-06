package servlet.alterar;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Tarefa;
import bean.Usuario;
import dao.TarefaDAO;

@WebServlet("/Alterar/tarefa")
public class AlterarTarefa extends HttpServlet {
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
      //Verifica se a tarefa � do funcion�rio
  		try {
  			// L� a tarefa do banco e valida se o ID � igual ao do funcion�rio atual
  			if(new TarefaDAO().ler(id).getIdCriador()!=usu.getId()) {
  				throw new ServletException("Somente o usuario criador pode alterar esse registro");
  			}
  		} catch (SQLException e) {
  			throw new ServletException("Tarefa n�o existe");
  		}
      //Cria a tarefa
    	Tarefa t = new Tarefa();
      t.setId(Integer.parseInt(req.getParameter("id")));
    	t.setNome(req.getParameter("nome"));
    	t.setDescricao(req.getParameter("descricao"));
    	t.setIdCriador(((Usuario) req.getSession().getAttribute("user")).getId());
    	try {
        t.setDataLimite( new SimpleDateFormat("yyyy-MM-dd").parse((req.getParameter("dataLimite"))));
  		} catch (ParseException e) {
        e.printStackTrace();
  		}
    	t.setSituacao(Integer.parseInt(req.getParameter("situacao")));
    	t.setValor(Double.parseDouble(req.getParameter("valor")));
      //Tenta alterar
    	try {
        new TarefaDAO().alterar(t);
        resp.sendRedirect("tarefalist.jsp");
        return;
    	} catch (Exception e) {
    		throw new ServletException("Nao conseguiu alterar");
    	}
    }
}
