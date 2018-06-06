<%@page import="bean.Tarefa"%>
<%@page import="dao.TarefaDAO"%>
<%@page session="true"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" type="text/css" href="tarefa.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-blue.min.css" />
<script defer="defer" src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</head>
<body>
	<div>
		<jsp:include page="/WEB-INF/hdr.jsp" />
	</div>
	<form method="post" action=<%=inclusao?"Incluir":"Alterar"%>>
		<div id="rectangle">
			<input type="hidden" value="tarefa" name="entidade" /> <input
				type="hidden" value=<%=t==null?"":t.getId()%> name="id" />
			<div
				class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="text" name="nome"
					value="<%=t==null?"":t.getNome()%>" required> <label
					class="mdl-textfield__label" for="nome">Nome</label>
			</div>
			<div
				class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="text" name="descricao"
					value="<%=t==null?"":t.getDescricao()%>" required> <label
					class="mdl-textfield__label" for="descricao">Descricao</label>
			</div>
			<div class="mdl-textfield mdl-js-textfield">
				<input class="mdl-textfield__input" type="date" name="dataLimite"
					value="<%=t==null?"":t.getDataLimite()%>" required>
			</div>
			<div
				class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="number" step="0.01"
					name="valor" value="<%=t==null?"0":t.getValor()%>" required>
				<label class="mdl-textfield__label" for="valor">Valor</label>
			</div>
			<%
    // Se nao esta em inclusao
    if(!inclusao){ %>
			<div>
				Situacao:<select name="situacao"
					value="<%=t==null?"1":t.getSituacao()%>">
					<option value=1>aberta</option>
					<option value=2>encerrada</option>
				</select>
			</div>
			<%} else {
//Cria componente com valor default 1 - Aberto
	%>
			<input type="hidden" value="1" name="situacao" />
			<% } %>
			<input
				class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
				type="submit" value="Criar" />
		</div>
	</form>
	<%
// Se nao esta em inclusao
    if(!inclusao){ %>
	<form method="post" action="Deletar">
		<input type="hidden" value="tarefa" name="entidade" /> <input
			type="hidden" value=<%=t==null?"":t.getId()%> name="id" /> <input
			class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
			type="submit" value="Deletar" />
	</form>
	<% } %>
</body>
</html>
