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

  <%-- CSS --%>
  <jsp:include page="/template/common/css.jsp" />
</head>
<body>
  <jsp:include page="/template/common/background.jsp" />

  <header data-active="aeronave">
    <div class="jumbotron">
      <div class="container">
        <h1>Cadastrar Aeronave</h1>
        <small id="clock"></small>
      </div>
    </div>

    <jsp:include page="/template/common/header.jsp" />
  </header>

  <article>
    <div class="container">

      <%-- Alerts --%>
      <jsp:include page="/alert/error.jsp" />
      <jsp:include page="/alert/success.jsp" />

      <div class="row">
        <form id="insert"
          action="${pageContext.request.contextPath}/api/aeronave"
          method="PUT">
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

<%-- JS --%>
<jsp:include page="/template/common/js.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/aeronave.js"></script>

</html>
