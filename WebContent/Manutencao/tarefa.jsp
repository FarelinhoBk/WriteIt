<%@page import="java.util.Date"%>
<%@page import="bean.Tarefa"%>
<%@page import="java.util.List"%>
<%@page import="dao.TarefaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page session="true" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% 
	String id = request.getParameter("id"); 
	boolean inclusao=false;
	Tarefa t;
	try { 
		t = new TarefaDAO().ler(Integer.valueOf(id));
	} catch ( Exception e) {
		inclusao = true;
		t = null;
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
      <input type="hidden" value="tarefa" name="entidade" />
      <input type="hidden" value=<%=t==null?"":t.getId()%> name="id" />
      <div>Nome:<input type="text" name="nome" value="<%=t==null?"":t.getNome()%>" required/></div>
      <div>Descricao:<input type="text" name="descricao"  value="<%=t==null?"":t.getDescricao()%>" required/></div>
      <div>Data Limite:<input type="date" name="dataLimite" value="<%=t==null?"":t.getDataLimite()%>" required></div>
      <div>Situação:<select name="situacao" value="<%=t==null?"1":t.getSituacao()%>">
					  <option value=1>aberta</option>
					  <option value=2>encerrada</option>
					</select></div>
      <div>Valor:<input type="number" step="0.01" name="valor" value="<%=t==null?"0":t.getValor()%>" required/></div>
      <input type="submit"/>
    </form>
    <% 
    // Se não está em inclusão
    if(!inclusao){ %> 
    <form method="post" action="Deletar">
      <input type="hidden" value="tarefa" name="entidade" />
      <input type="hidden" value=<%=t==null?"":t.getId()%> name="id" />
      <button type="submit">Deletar</button>
    </form>
    <% } %>
  </body>
</html>
