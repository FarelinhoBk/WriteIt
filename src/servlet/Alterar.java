package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Alterar")
public class Alterar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Valida a tarefa
        String entidade = req.getParameter("entidade");
        if(entidade==null)throw new ServletException("Sem entidade");
        //Valida o usuário
        if(req.getSession().getAttribute("user")==null) {
        	resp.sendRedirect("login");
        	return;
        }
        //Redireciona para o servlet responsável pela manuteção
        req.getRequestDispatcher("/Alterar/"+entidade).forward(req, resp);
    }
}
