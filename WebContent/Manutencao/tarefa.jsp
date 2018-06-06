<%@page import="bean.Tarefa"%>
<%@page import="dao.TarefaDAO"%>
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
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-blue.min.css" />
    <script defer="defer" src="https://code.getmdl.io/1.3.0/material.min.js"></script>
  </head>
  <body>
    <jsp:include page="/WEB-INF/hdr.jsp"/>
    <form method="post" action=<%=inclusao?"Incluir":"Alterar"%> >
      <input type="hidden" value="tarefa" name="entidade" />
      <input type="hidden" value=<%=t==null?"":t.getId()%> name="id" />
      <div>Nome:<input type="text" name="nome" value="<%=t==null?"":t.getNome()%>" required/></div>
      <div>Descricao:<input type="text" name="descricao"  value="<%=t==null?"":t.getDescricao()%>" required/></div>
      <div>Data Limite:<input type="date" name="dataLimite" value="<%=t==null?"":t.getDataLimite()%>" required></div>
      <div>Situa��o:<select name="situacao" value="<%=t==null?"1":t.getSituacao()%>">
					  <option value=1>aberta</option>
					  <option value=2>encerrada</option>
					</select></div>
      <div>Valor:<input type="number" step="0.01" name="valor" value="<%=t==null?"0":t.getValor()%>" required/></div>
      <input type="submit"/>
    </form>
    <%
    // Se n�o est� em inclus�o
    if(!inclusao){ %>
    <form method="post" action="Deletar">
      <input type="hidden" value="tarefa" name="entidade" />
      <input type="hidden" value=<%=t==null?"":t.getId()%> name="id" />
      <button type="submit">Deletar</button>
    </form>
    <% } %>
  </body>
</html>
