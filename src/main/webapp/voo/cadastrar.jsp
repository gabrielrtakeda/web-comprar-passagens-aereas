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
  <title>Cadastrar Vôo</title>

  <%-- CSS --%>
  <jsp:include page="/template/common/css.jsp" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/voo.css" />
</head>

<body>
  <jsp:include page="/template/common/background.jsp" />

  <header data-active="voo">
    <div class="jumbotron">
      <div class="container">
        <h1>Cadastrar Vôo</h1>
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


      <%-- Aeronave --%>
      <form id="consultar-aeronave"
        method="GET"
        class="form-inline form-aeronave">

        <div class="row">
          <jsp:include page="/aeronave/partials/consultar-form-content.jsp" />
          <jsp:include page="/aeronave/partials/consultar-table-dataonly.jsp" />
        </div>
      </form>


      <%-- Vôo --%>
      <form id="cadastrar-voo"
        action="${pageContext.request.contextPath}/api/voo"
        method="PUT">
        <input id="aeronave-id" type="hidden" name="aeronaveId" required />
        <jsp:include page="/voo/partials/cadastrar-form-content.jsp" />
        <jsp:include page="/voo/partials/cadastrar-form-content-buttons.jsp" />
      </form>

    </div> <%-- /container --%>
  </article>

  <footer></footer>

</body>

<%-- JS --%>
<jsp:include page="/template/common/js.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/helper/AeronaveConsultaHelper.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/voo.js"></script>

</html>
