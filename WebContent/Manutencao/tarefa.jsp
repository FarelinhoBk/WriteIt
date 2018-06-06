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
<link rel="stylesheet"	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-blue.min.css">
<script defer="defer" src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</head>
<body>
	<div>
		<jsp:include page="/WEB-INF/hdr.jsp" />
	</div>

<style>
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
		<div id="rectangle">
	<form method="post" action=<%=inclusao?"Incluir":"Alterar"%>>
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
<!-- Simple Select -->
  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <select class="mdl-textfield__input" id="situacao" name="situacao" value="<%=t==null?"1":t.getSituacao()%>">
      <option value="1">Aberta</option>
      <option value="2">Encerrada</option>
    </select>
    <label class="mdl-textfield__label" for="situacao">Situacao</label>
  </div>
			<%} else {
//Cria componente com valor default 1 - Aberto
	%>
			<input type="hidden" value="1" name="situacao" />
			<% } %>
			<br />
<%if(!inclusao){ %>
			<span style="float:left">
<% } %>
				<input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" value="<%=inclusao?"Criar":"Alterar"%>" />
<%if(!inclusao){ %>
			</span>
<% } %>
	</form>
	<%
// Se nao esta em inclusao
    if(!inclusao){ %>
	<form method="post" action="Deletar">
		<input type="hidden" value="tarefa" name="entidade" />
		<input type="hidden" value="<%=t==null?"":t.getId()%>" name="id" />
		<span style="float:right">
			<input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" value="Deletar" />
		</span>
	</form>
	<% } %>
</div>
</body>
</html>
