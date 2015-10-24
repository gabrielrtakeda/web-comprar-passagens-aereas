<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Registrar Aeronave</title>
  <link rel="stylesheet" href="./../node_modules/bootstrap/dist/css/bootstrap.min.css">
</head>
<body>

  <header>
    <div class="jumbotron">
      <div class="container">
        <h1>Cadastrar Aeronave</h1>
      </div>
    </div>
  </header>

  <article>
    <div class="container">

      <div id="error-alert" class="alert alert-danger hide" role="alert">
        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
        <span class="sr-only">Erro:</span>
      </div>

      <div class="row">
        <form id="insert"
          action="${pageContext.request.contextPath}/api/aeronave"
          method="PUT"
        >
          <jsp:include page="/aeronave/partials/cadastrar-form-content.jsp" />
          <div class="col-md-12 text-right">
              <button type="submit" class="btn btn-primary">cadastrar</button>
          </div>
        </form>
      </div> <!-- /row -->
    </div> <!-- /container -->
  </article>

  <footer></footer>

</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/node_modules/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/network/handler/AsynchronousRequestHandler.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/aeronave.js"></script>

</html>
