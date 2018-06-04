<%@page import="bean.Usuario"%>
<%
Usuario usu;
try {
  usu = (Usuario) request.getSession().getAttribute("user");
} catch (Exception e) {
  usu = null;
}
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">WriteIt</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="index.jsp">Home</a>
      </li>
    </ul>
    <ul class="navbar-nav">
      <li class="nav-item">
        <% if(usu==null) {%>
          <a class="nav-link active" href="login">Login</a>
	  	  <% } else { %>
      	  <a class="nav-link active" href="usurio.jsp"><%=usu.getNome()%></a>
		    <% }%>
      </li>
    </ul>
  </div>
</nav>
