<%@page import="bean.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="bean.Tarefa"%>
<%@page import="java.util.List"%>
<%@page import="dao.TarefaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page session="true" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	//Valida o usuï¿½rio
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("login");
		return;
	}
	Usuario usu = (Usuario) request.getSession().getAttribute("user");
%>
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
<<<<<<< HEAD



//TODO: Criar botoes de edit, delete?
=======
	<%
	//Se for empresa adiciona linha para incluir
	if(usu.isEmpresa()) {	%>
>>>>>>> 5124b5abe26cec8bc0cca1ea864fb7e1b8acb16f
<a id="task-create" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored mdl-color-text--white" href="Manutencao?entidade=tarefa">
<i class="material-icons">add</i>
</a>
</div>
	<%	}	%>

<div id="rectangle">
<table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric">Nome</th>
      <th>Descricao</th>
      <th>Situação</th>
      <th>Data Limite</th>
      <th>Criador</th>
      <th>Valor</th>
    </tr>
  </thead>
  <tbody>
		<%
			TarefaDAO dao = new TarefaDAO();
			List<Tarefa> tarefas = dao.findAll();
			for (Tarefa t : tarefas) {
				Usuario criador = new UsuarioDAO().ler(t.getIdCriador());
				//Se o usuï¿½rio for uma empresa sï¿½ deixa ver as proprias tarefas
				if(usu.isEmpresa()&usu.getId()!=criador.getId()) {
					continue;
				}
		%>
	   <tr>
	     <td class="mdl-data-table__cell--non-numeric"><%=t.getNome()%></td>
	     <td><%=t.getDescricao()%></td>
	     <td><%=t.getSituacao()%></td>
	     <td><%=t.getDataLimite()%></td>
	     <td><%=criador.getNome()%></td>
	     <td><%=t.getValor()%></td>
		<%
				//Se for empresa adiciona linha para incluir
				if(usu.isEmpresa()) {	%>
					<td><a id="task-???" href="Manutencao?entidade=tarefa&id=<%=t.getId()%>">Alterar</a></td>
					<td><a id="task-delete" href="Deletar?entidade=tarefa&id=<%=t.getId()%>">Deletar</a></td>
		<%		};	%>
			 <td><a id="task-???" href="aplicacaolist.jsp?idTarefa=<%=t.getId()%>"><%=usu.isFreelancer()?"Inscrever":"Ver inscrições"%></a></td>
		<% }%>
	   <tr>
  </tbody>
</table>
</div>




</body>
</html>
