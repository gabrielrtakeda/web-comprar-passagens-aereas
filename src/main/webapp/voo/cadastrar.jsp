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

  <%-- General --%>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />

  <%-- Custom --%>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/consulta-table.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/voo.css" />
</head>
<body>

  <header>
    <div class="jumbotron">
      <div class="container">
        <h1>Cadastrar Vôo</h1>
      </div>
    </div>
  </header>

  <article>
    <div class="container">

      <%-- Alerts --%>
      <jsp:include page="/alert/error.jsp" />
      <jsp:include page="/alert/success.jsp" />


      <%-- Aeronave --%>
      <form id="consultar-aeronave"
        action="${pageContext.request.contextPath}/api/aeronave/list/"
        method="GET"
        class="form-inline form-aeronave">

        <div class="row">
          <jsp:include page="/aeronave/partials/consultar-form-content.jsp" />
          <jsp:include page="/aeronave/partials/consultar-table.jsp" />
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

<%-- General --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/node_modules/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/node_modules/jquery-mask-number/jquery.masknumber.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bower_components/moment/min/moment.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>

<%-- Custom --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/utils/Serialize.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/network/handler/AsynchronousRequestHandler.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/helper/AeronaveConsultaHelper.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/helper/RowDataExtractHelper.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/voo.js"></script>

</html>
