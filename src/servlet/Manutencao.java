package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Manutencao")
public class Manutencao extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entidade = req.getParameter("entidade");
        req.setAttribute("entidade", null);
        
        req.getRequestDispatcher("/Manutencao/"+entidade+".jsp").forward(req, resp);
    }
}
