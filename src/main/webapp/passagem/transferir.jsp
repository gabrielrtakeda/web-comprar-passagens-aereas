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
  <title>Transferir Passagem</title>

  <%-- CSS --%>
  <jsp:include page="/template/common/css.jsp" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/passagem/transferir.css" />
</head>

<body>
  <jsp:include page="/template/common/background.jsp" />

  <header data-active="passagem">
    <div class="jumbotron">
      <div class="container">
        <h1>Transferir Passagem</h1>
        <small id="clock"></small>
      </div>
    </div>

    <jsp:include page="/template/common/header.jsp" />
  </header>

  <article>
    <section class="container consulta-passagem">
      <jsp:include page="/alert/error.jsp" />
      <jsp:include page="/alert/success.jsp" />

      <form id="consultar-passagem"
        method="GET"
        class="form-inline">

        <div class="container">
          <div class="row">
            <h3>Passagem</h3>
            <div class="col-md-4 col-sm-12">
                <div class="form-group">
                  <label for="input-nome-aeronave" class="sr-only">Bilhete</label>
                  <input id="input-codigo-aeronave"
                    type="text"
                    class="form-control"
                    placeholder="Bilhete"
                    name="bilhete"
                    required
                    autofocus
                  />
                  <button type="submit" class="btn btn-primary">consultar</button>
                </div>
            </div>
          </div>
        </div>
      </form>
    </section>

    <form id="transferir-passagem"
      action="${pageContext.request.contextPath}/api/passagem"
      method="POST">
      <input type="hidden" name="id" required />
      <input type="hidden" name="vooId" required />
      <section class="dados-passagem"></section>

      <div class="container">
        <div class="row">
          <jsp:include page="/voo/partials/consultar-disponiveis-table-dataonly.jsp" />
        </div> <%-- /row --%>
      </div>

      <section class="container action-buttons">
        <div class="col-md-12 text-right">
          <button type="submit" class="btn btn-primary">transferir</button>
        </div>
      </section>
    </form>

  </article>
  <footer></footer>
</body>

<%-- JS --%>
<jsp:include page="/template/common/js.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/passagem/transferir.js"></script>

</html>
