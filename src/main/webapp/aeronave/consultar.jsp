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
        <h1>Alterar Aeronave</h1>
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

      <%-- Consultar --%>
      <jsp:include page="/aeronave/partials/alterar-consultar-form.jsp" />
      <jsp:include page="/aeronave/partials/alterar-consultar-table.jsp" />

      <%-- Alterar --%>
      <jsp:include page="/aeronave/partials/alterar-form.jsp" />

    </div> <!-- /container -->
  </article>

  <footer></footer>

</body>

<%-- JS --%>
<jsp:include page="/template/common/js.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/aeronave.js"></script>

</html>
