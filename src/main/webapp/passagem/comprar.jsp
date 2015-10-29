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

  <%-- CSS --%>
  <jsp:include page="/template/common/css.jsp" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/passagem/comprar.css" />
</head>

<body>
  <jsp:include page="/template/common/background.jsp" />

  <header data-active="passagem">
    <div class="jumbotron">
      <div class="container">
        <h1>Comprar Passagem</h1>
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

      <%-- Vôo --%>
      <form id="consultar-voo"
        method="GET"
        class="form-consultar-voo">

        <div class="row">
          <jsp:include page="/voo/partials/consultar-form-content.jsp" />
          <jsp:include page="/voo/partials/consultar-form-content-buttons.jsp" />
        </div> <%-- /row --%>

        <jsp:include page="/voo/partials/consultar-disponiveis-table-dataonly.jsp" />
      </form>

      <%-- Passagens --%>
      <jsp:include page="/passagem/partials/cadastrar-form-content-header.jsp" />

      <%-- Passageiros --%>
      <form id="comprar-passagem"
        action="${pageContext.request.contextPath}/api/passagem/"
        method="PUT">
        <input id="voo-id" type="hidden" name="vooId" required />
        <input id="valor-total" type="hidden" name="valorTotal" value="0" required />
        <div class="container">
          <div id="passageiros-container"></div>
          <jsp:include page="/passagem/partials/cadastrar-form-content-buttons.jsp" />
        </div> <%-- /container --%>
      </form>

    </div> <%-- /container --%>
  </article>

  <footer></footer>

</body>

<%-- JS --%>
<jsp:include page="/template/common/js.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/helper/VooConsultaHelper.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/helper/CadastroCompraPassagemHelper.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/passagem/comprar.js"></script>

</html>
