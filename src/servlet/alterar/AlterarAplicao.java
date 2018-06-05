package servlet.alterar;

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

@WebServlet("/Alterar/tarefa")
public class AlterarAplicao extends HttpServlet {
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
      //Verifica se a aplicacão é do funcionário
			try {
        // Lê a aplicação do banco e valida se o ID é igual ao do funcionário atual
				if(new AplicaoDAO().ler(id).getIdUsuario()!=usu.getId()) {
          throw new ServletException("Somente o usuario criador pode alterar esse registro");
        }
			} catch (SQLException e) {
				throw new ServletException("Aplicação não existe");
			}
      //Carrega os dados da aplicacão
      Aplicao a = new Aplicao();
      a.setidTarefa(Integer.parseInt(req.getParameter("idTarefa")));
      a.setTexto(req.getParameter("texto"));
      a.setTexto(req.getParameter("observacoes"));
      try {
        a.setdataDeAplicao( new SimpleDateFormat("yyyy-MM-dd").parse((req.getParameter("dataDeAplicacao"))));
      } catch (ParseException e) {
        e.printStackTrace();
      }
      //Tenta alterar
    	try {
        new AplicaoDAO().alterar(a);
        resp.sendRedirect("tarefalist.jsp");
        return;
    	} catch (Exception e) {
    		throw new ServletException("Nao conseguiu alterar");
    	}
    }
}
