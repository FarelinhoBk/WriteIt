<%@page import="dao.AplicaoDAO"%>
<%@page import="bean.Aplicao"%>
<%@page session="true" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% 
	String id = request.getParameter("id");
	int idTarefa=0; 
	boolean inclusao=false;
	Aplicao a;
	try { 
		a = new AplicaoDAO().ler(Integer.valueOf(id));
	} catch ( Exception e) {
		try {
			idTarefa = Integer.valueOf(request.getParameter("idTarefa")); 
		} catch ( Exception exp) {
		    throw new ServletException("Sem ID da tarefa");
		}
		inclusao = true;
		a = null;
	}
	
%>
<html>
  <head>
    <title>Manutencao - Tarefa</title>
    <link rel="stylesheet" href="./tarefa.css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
  </head>
  <body>
    <jsp:include page="/WEB-INF/header.jsp"/>
    <form method="post" action=<%=inclusao?"Incluir":"Alterar"%> >
      <input type="hidden" value="aplicacao" name="entidade" />
      <input type="hidden" value=<%=a==null?"0":a.getId()%>  name="id" />
      <input type="hidden" value=<%=a==null?idTarefa:a.getIdTarefa()%> name="idTarefa" />
      <div>Texto:<input type="text" name="texto"  value="<%=a==null?"":a.getTexto()%>" required/></div>
      <div>Observação:<input type="text" name="observacoes"  value="<%=a==null?"":a.getObservacoes()%>" required/></div>
      <input type="submit"/>
    </form>
    <% 
    // Se não está em inclusão
    if(!inclusao){ %> 
    <form method="post" action="Deletar">
      <input type="hidden" value="tarefa" name="entidade" />
      <input type="hidden" value=<%=a==null?"":a.getId()%> name="id" />
      <button type="submit">Deletar</button>
    </form>
    <% } %>
  </body>
</html>
