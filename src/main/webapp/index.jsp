<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Acesso</title>
  <link rel="stylesheet" type="text/css" href="./node_modules/bootstrap/dist/css/bootstrap.min.css">
  <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
</head>
<body>
  <header>
    <div class="jumbotron">
      <div class="container">
        <h1>Sistema de Compra de Passagens Aéreas</h1>
      </div>
    </div>
  </header>


  <article>
    <div class="container">

      <div id="error-alert" class="alert alert-danger hide" role="alert">
        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
        <span class="sr-only">Error:</span>
      </div>

      <section class="internationalization">
        <div class="row">
          <div class="text-center">
            <p><label>Selecione seu idioma:</label></p>
            <img src="./images/flags/brazil.png" />
            <img src="./images/flags/spain.png" />
            <img src="./images/flags/usa.png" />
          </div>
        </div>
      </section>

      <form id="authentication"
        action="${pageContext.request.contextPath}/api/authentication"
        method="POST"
      >
        <div class="form-group">
          <label for="inputUser">Autenticação</label>
          <input id="inputUser"
            type="text"
            class="form-control"
            placeholder="Usuário"
            name="usuario"
            autofocus
          />
        </div>
        <div class="form-group">
          <input type="password"
            class="form-control"
            placeholder="Senha"
            name="senha"
          />
        </div>
        <div class="form-group text-right">
          <button type="submit" class="btn btn-primary">Submit</button>
        </div>
      </form>

    </div> <!-- /container -->
  </article>


  <footer></footer>
</body>

<script type="text/javascript" src="./node_modules/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="./js/index.js"></script>

</html>
