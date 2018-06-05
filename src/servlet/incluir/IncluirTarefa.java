package servlet.incluir;

import java.io.IOException;
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

@WebServlet("/Incluir/tarefa")
public class IncluirTarefa extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Tarefa t = new Tarefa();
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
    	try {
    		new TarefaDAO().incluir(t);
            resp.sendRedirect("tarefalist.jsp");
            return;
    	} catch (Exception e) {
    		throw new ServletException("Nao conseguiu incluir");
    	}
    }
}