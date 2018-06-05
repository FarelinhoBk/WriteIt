<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  <!DOCTYPE html>
  <html>
  <head>
    <title>WriteIt - Login</title>
    <!-- Google material -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-blue.min.css" />
    <script defer="defer" src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <link rel="stylesheet" type="text/css" href="login.css">
  </head>
  <body>
    <jsp:include page="WEB-INF/hdr.jsp" />
    <form method="post" action="ValidLogin">
      <div id="rectangle">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
          <input class="mdl-textfield__input" type="text" name="username">
          <label class="mdl-textfield__label" for="password">Username</label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
          <input class="mdl-textfield__input" type="password" name="senha">
          <label class="mdl-textfield__label" for="senha">Password</label>
        </div>
        <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" value="Login" />
      </div>
    </form>
  </body>
  </html>
