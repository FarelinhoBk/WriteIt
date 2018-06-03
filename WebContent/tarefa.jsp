<%@page import="bean.Tarefa"%>
<%@page import="java.util.List"%>
<%@page import="dao.TarefaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Tarefas</title>
    <link rel="stylesheet" href="./tarefa.css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
  </head>
  <body>
    <jsp:include page="WEB-INF/header.tag"/>
     <%
 	TarefaDAO dao = new TarefaDAO();
    List<Tarefa> tarefas = dao.findAll();
	if(!tarefas.isEmpty()){
	    for (Tarefa t:tarefas ) {
	    %>
	        <li><%=t.getNome()%>, <%=t.getDescricao()%>, <%=t.getValor()%></li>
	    <%
    	}
    } else { 
    %>
       <p>Nenhuma tarefa encontrada</p>
    <%
    }
    %>

  </body>
</html>
