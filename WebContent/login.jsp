<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  <!DOCTYPE html>
  <html>
    <head>
      <title>WriteIt - Login</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous"/>
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
      <!-- Google material -->
      <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
          <script defer="defer" src="https://code.getmdl.io/1.3.0/material.min.js"></script>
          <link rel="stylesheet" type="text/css" href="login.css"></head>
          <body>
            <jsp:include page="WEB-INF/header.jsp"/>
            <form method="post" action="ValidLogin">
              <div id="rectangle">
                <div class="mdl-textfield mdl-js-textfield">
                  <input class="mdl-textfield__input" type="text" name="username">
                    <label class="mdl-textfield__label" for="password">Username</label>
                  </div>
                  <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" name="senha">
                      <label class="mdl-textfield__label" for="senha">Password</label>
                    </div>
                    <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect" type="submit" value="Login"/>
                  </div>
                </form>
              </body>
            </html>
