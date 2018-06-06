<%@page import="bean.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="bean.Tarefa"%>
<%@page import="java.util.List"%>
<%@page import="dao.TarefaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page session="true"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	//Valida o usuario
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
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-blue.min.css" />
<script defer="defer" src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<link rel="stylesheet" type="text/css" href="tarefalist.css">
</head>
<body>
	<div>
		<jsp:include page="WEB-INF/hdr.jsp" />
		<br />
	</div>
	<br />
	<br />
	<div>
		<%
			//Se for empresa adiciona linha para incluir
			if (usu.isEmpresa()) {
		%>
		<a id="task-create"
			class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored mdl-color-text--white"
			href="Manutencao?entidade=tarefa"> <i class="material-icons">add</i>
		</a>
	</div>
	<%
		}
	%>

	<%
		TarefaDAO dao = new TarefaDAO();
		List<Tarefa> tarefas = dao.findAll();
		for (Tarefa t : tarefas) {
			Usuario criador = new UsuarioDAO().ler(t.getIdCriador());
			//Se o usuario for uma empresa so deixa ver as proprias tarefas
			if (usu.isEmpresa() & usu.getId() != criador.getId()) {
				continue;
			}
	%>

	<!-- Square card -->
	<div class="mdl-card mdl-shadow--2dp demo-card-square">
		<div class="mdl-card__title mdl-card--expand">
			<%
				if (usu.isEmpresa()) {
			%>
			<!-- Se for empresa, adiciona situacao -->
			<%
				if (t.getSituacao() == 1) {
			%>
			<h2 class="mdl-card__title-text">Aberto</h2>
			<%
				} else {
			%>
			<h2 class="mdl-card__title-text">Fechado</h2>
			<%
				}
						;
			%>
			<%
				} else {
			%>
			<h2 class="mdl-card__title-text"><%=criador.getNome()%></h2>
			<%
				}
					;
			%>
		</div>
		<div class="mdl-card__supporting-text">
			<%=t.getDescricao()%>
		</div>
		<div class="mdl-card__actions mdl-card--border">
			<a
				class="mdl-button mdl-button--accent mdl-js-button mdl-js-ripple-effect"
				id="task-???" href="aplicacaolist.jsp?idTarefa=<%=t.getId()%>"><%=usu.isFreelancer() ? "Inscrever" : "Inscricoes"%></a>
			<!-- Se for empresa, adiciona liinha de edicao -->
			<%
				if (usu.isEmpresa()) {
			%>
			<a
				class="mdl-button mdl-button--accent mdl-js-button mdl-js-ripple-effect"
				id="task-???" href="Manutencao?entidade=tarefa&id=<%=t.getId()%>">Alterar</a>
			<a
				class="mdl-button mdl-button--accent mdl-js-button mdl-js-ripple-effect"
				id="task-delete" href="Deletar?entidade=tarefa&id=<%=t.getId()%>">Deletar</a>
			<%
				}
					;
			%>
		</div>
	</div>
	<%
		}
	%>

</body>
</html>
