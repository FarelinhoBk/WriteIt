<%@page import="bean.Tarefa"%>
<%@page import="java.util.List"%>
<%@page import="dao.TarefaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page session="true" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Tarefas</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-blue.min.css" />
    <script defer="defer" src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <link rel="stylesheet" href="./tarefalist.css">
  </head>
<body>
	<jsp:include page="WEB-INF/hdr.jsp" />
<div>

//TODO: Nao leu CSS, verificar pasta
<style>
    #task-create {
      position: fixed;
      display: block;
      right: 0;
      bottom: 0;
      margin-right: 40px;
      margin-bottom: 40px;
      z-index: 900;
    }
#rectangle {
  margin: auto;
  text-align: center;
  width: 300px;
  height: 230px;
  background: white;
  border-radius: 10px;
  padding: 10px;
  position: relative;
  top: 50%;
  transform: translateY(50%);
  -webkit-transform: translateY(50%);
  -ms-transform: translateY(50%);
}
</style>


//TODO: Criar botoes de edit, delete?
<a id="task-create" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored mdl-color-text--white" href="Manutencao?entidade=tarefa">
<i class="material-icons">add</i>
</a>
</div>

<div id="rectangle">
<table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric">Nome</th>
      <th>Descricao</th>
      <th>Valor</th>
    </tr>
  </thead>
  <tbody>
		<%
			TarefaDAO dao = new TarefaDAO();
			List<Tarefa> tarefas = dao.findAll();
			for (Tarefa t : tarefas) {
		%>
    <tr>
      <td class="mdl-data-table__cell--non-numeric"><%=t.getNome()%></td>
      <td><%=t.getDescricao()%></td>
      <td><%=t.getValor()%></td>
    </tr>
		<%
			}
		%>
  </tbody>
</table>
</div>




</body>
</html>
