package servlet.incluir;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Aplicao;
import bean.Usuario;
import dao.AplicaoDAO;

@WebServlet("/Incluir/aplicacao")
public class IncluirAplicao extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //Carrega os dados da aplicac�o
    	Aplicao a = new Aplicao();
    	a.setIdTarefa(Integer.parseInt(req.getParameter("idTarefa")));
    	a.setIdUsuario(((Usuario) req.getSession().getAttribute("user")).getId());
    	a.setTexto(req.getParameter("texto"));
    	a.setObservacoes(req.getParameter("observacoes"));
    	a.setDataDeAplicao(new Date());
      //Tenta incluir
    	try {
    		new AplicaoDAO().incluir(a);
            resp.sendRedirect("tarefalist.jsp");
            return;
    	} catch (Exception e) {
    		throw new ServletException("Nao conseguiu incluir: " + e.getMessage());
    	}
    }
}
