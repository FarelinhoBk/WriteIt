package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Usuario;
import dao.UsuarioDAO;

@WebServlet("/ValidLogin")
public class ValidLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
        try
        {
          String username = req.getParameter("username");
          String senha = req.getParameter("senha");
          Usuario usu = new UsuarioDAO().lerValid(username,senha);
          req.getSession().setAttribute("user",usu);
          resp.sendRedirect("index.jsp");
        }
        catch(Exception e)
        {
          //Volta pra tela de login com erro
          req.setAttribute("error", "Usuario e/ou senha inv�lido");
          req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
