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
  <title>Comprar Passagem</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/consulta-table.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/passagem/comprar.css" />
</head>
<body>

  <header>
    <div class="jumbotron">
      <div class="container">
        <h1>Comprar Passagem</h1>
      </div>
    </div>
  </header>

  <article>
    <div class="container">

      <%-- Alerts --%>
      <jsp:include page="/alert/error.jsp" />
      <jsp:include page="/alert/success.jsp" />

      <%-- Vôo --%>
      <form id="consultar-voo"
        action="${pageContext.request.contextPath}/api/voo/list/"
        method="GET"
        class="form-consultar-voo">

        <div class="row">
          <jsp:include page="/voo/partials/consultar-form-content.jsp" />
          <jsp:include page="/voo/partials/consultar-form-content-buttons.jsp" />
          <jsp:include page="/voo/partials/consultar-disponiveis-table-dataonly.jsp" />
        </div> <%-- /row --%>
      </form>

      <%-- Passagens --%>
      <jsp:include page="/passagem/partials/cadastrar-form-content-header.jsp" />

      <%-- Passageiros --%>
      <form id="comprar-passagem"
        action="${pageContext.request.contextPath}/api/passagem/"
        method="PUT">
        <input id="voo-id" type="hidden" name="vooId" required />
        <div class="container">
          <div id="passageiros-container"></div>
          <jsp:include page="/passagem/partials/cadastrar-form-content-buttons.jsp" />
        </div> <%-- /container --%>
      </form>

    </div> <%-- /container --%>
  </article>

  <footer></footer>

</body>

<%-- General --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/node_modules/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/node_modules/form-serializer/dist/jquery.serialize-object.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/node_modules/jquery-number/jquery.number.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/node_modules/jquery-mask-plugin/dist/jquery.mask.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bower_components/moment/min/moment.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>

<%-- Custom --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/network/handler/AsynchronousRequestHandler.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/utils/Serialize.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/helper/AlertHelper.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/helper/VooConsultaHelper.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/helper/RowDataExtractHelper.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/helper/CadastroCompraPassagemHelper.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/passagem/comprar.js"></script>

</html>
