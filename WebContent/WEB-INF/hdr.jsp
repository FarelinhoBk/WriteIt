<!DOCTYPE html>
<%@page import="bean.Usuario"%>
<%
Usuario usu;
try {
  usu = (Usuario) request.getSession().getAttribute("user");
} catch (Exception e) {
  usu = null;
}
%>
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
        <link href="./img/favicon.ico" rel="icon" type="image/x-icon" />
      <header class="mdl-layout__header">
        <div class="mdl-layout__header-row">
          <!-- Title -->
          <span class="mdl-layout-title">WriteIt</span>
          <!-- Add spacer, to align navigation to the right -->
          <div class="mdl-layout-spacer"></div>
          <!-- Navigation. We hide it in small screens. -->
          <nav class="mdl-navigation mdl-layout--large-screen-only">
            <% if(usu==null) {%>
              <a class="mdl-navigation__link" href="login">Login</a>
            <% } else { %>
              <%=usu.getNome()%>
            <% }%>
          </nav>
        </div>
      </header>

      <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">WriteIt</span>
        <nav class="mdl-navigation">
          <a class="mdl-navigation__link" href="index.jsp">Home</a>
          <a class="mdl-navigation__link" href="tarefalist.jsp">Tarefas</a>
            <% if(usu!=null) {%>
              <a class="mdl-navigation__link" href="logout">Logout</a>
            <% } %>
        </nav>
      </div>
    </div>
