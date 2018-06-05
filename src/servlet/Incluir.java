package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Incluir")
public class Incluir extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entidade = req.getParameter("entidade");
        if(entidade==null)throw new ServletException("Sem entidade");
        if(req.getSession().getAttribute("user")==null) {
        	resp.sendRedirect("login");
        	return;
        }
        req.getRequestDispatcher("/Incluir/"+entidade).forward(req, resp);
    }
}