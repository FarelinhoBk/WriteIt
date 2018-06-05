package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Se ja tem usuário manda pra pagina inicial
       if (req.getSession().getAttribute("user")==null) {
           req.getRequestDispatcher("login.jsp").forward(req, resp);
       } else {
    	   resp.sendRedirect("index.jsp");
       }
	}
	
	

}
