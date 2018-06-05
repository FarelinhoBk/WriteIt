package servlet.incluir;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Aplicao;
import bean.Usuario;
import dao.AplicaoDAO;

@WebServlet("/Incluir/aplicao")
public class IncluirAplicao extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //Carrega os dados da aplicacão
    	Aplicao a = new Aplicao();
    	a.setidTarefa(Integer.parseInt(req.getParameter("idTarefa")));
    	a.setIdUsuario(((Usuario) req.getSession().getAttribute("user")).getId());
    	a.setTexto(req.getParameter("texto"));
    	a.setTexto(req.getParameter("observacoes"));
    	try {
  			a.setdataDeAplicao( new SimpleDateFormat("yyyy-MM-dd").parse((req.getParameter("dataDeAplicacao"))));
  		} catch (ParseException e) {
  			e.printStackTrace();
  		}
      //Tenta incluir
    	try {
    		new AplicaoDAO().incluir(a);
            resp.sendRedirect("tarefalist.jsp");
            return;
    	} catch (Exception e) {
    		throw new ServletException("Nao conseguiu incluir");
    	}
    }
}
