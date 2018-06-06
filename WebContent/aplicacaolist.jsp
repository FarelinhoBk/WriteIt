<%@page import="bean.Aplicao"%>
<%@page import="dao.AplicaoDAO"%>
<%@page import="java.util.List"%>
<%@page import="bean.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="bean.Tarefa"%>
<%@page import="dao.TarefaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page session="true" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	//Valida o usu�rio
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("login");
		return;
	}
	Usuario usu = (Usuario) request.getSession().getAttribute("user");
	//Busca id da tarefa
	if (request.getParameter("idTarefa") == null)
		throw new ServletException("Sem ID");
	int idTarefa = Integer.parseInt(request.getParameter("idTarefa"));

%>
<!DOCTYPE html>
<html>
  <head>
    <title>Aplicacoes</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-blue.min.css" />
    <script defer="defer" src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <link rel="stylesheet" type="text/css" href="aplicacaolist.css">
  </head>
<body>
	<jsp:include page="WEB-INF/hdr.jsp" />
<div>


	<%
	//Se for freelancer adiciona linha para incluir
	if(usu.isFreelancer()) {	%>
<a id="task-create" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored mdl-color-text--white" href="Manutencao?entidade=aplicacao&idTarefa=<%=idTarefa%>">
<i class="material-icons">add</i>
</a>
</div>
	<%	}	%>

<div id="rectangle">
<table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric">Criador</th>
      <th>Texto</th>
      <th>Data de aplica��o</th>
      <th>Observ��es</th>
    </tr>
  </thead>
  <tbody>
		<%
			List<Aplicao> aplicaos = new AplicaoDAO().lerPorTarefa(idTarefa);
			for (Aplicao a : aplicaos) {
				Usuario criador = new UsuarioDAO().ler(a.getIdUsuario());
				//Se o usu�rio for um freelancer s� deixa ver as proprias aplica��es
				if(usu.isFreelancer()&usu.getId()!=criador.getId()) continue;
		%>
    <tr>
      <td class="mdl-data-table__cell--non-numeric"><%=criador.getNome()%></td>
      <td><%=a.getTexto()%></td>
      <td><%=a.getDataDeAplicao()%></td>
      <td><%=a.getObservacoes()%></td>
		<%
				//Se for freelancer adiciona linha para incluir
				if(usu.isFreelancer()) {	%>
					<td><a id="task-???" href="Manutencao?entidade=aplicacao&id=<%=a.getId()%>">Alterar</a></td>
					<td><a id="task-delete" href="Deletar?entidade=aplicacao&id=<%=a.getId()%>">Deletar</a></td>
		<%		} %>
    </tr>
		<%
			}
		%>
  </tbody>
</table>
</div>




</body>
</html>
