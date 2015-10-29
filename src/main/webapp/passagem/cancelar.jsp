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
  <title>Cancelar Passagem</title>

  <%-- CSS --%>
  <jsp:include page="/template/common/css.jsp" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/passagem/cancelar.css" />
</head>

<body>
  <jsp:include page="/template/common/background.jsp" />

  <header data-active="passagem">
    <div class="jumbotron">
      <div class="container">
        <h1>Cancelar Passagem</h1>
        <small id="clock"></small>
      </div>
    </div>

    <jsp:include page="/template/common/header.jsp" />
  </header>

  <article>
    <section class="alerts">
      <jsp:include page="/alert/error.jsp" />
      <jsp:include page="/alert/success.jsp" />
    </section>

    <section class="consulta-passagem container">
      <h2>Passagem</h2>

      <form id="consultar-passagem"
        method="GET"
        class="form-inline">
        <div class="container">
          <div class="row">
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
        </div> <%-- /container --%>
      </form>
    </section>

    <section id="dados-passagem"></section>

    <form id="cancelar-passagem"
      action="${pageContext.request.contextPath}/api/passagem"
      method="POST">
      <input id="id" type="hidden" name="id" required />

      <section class="container action-buttons">
        <div class="col-md-12 text-right">
          <a href="${pageContext.request.contextPath}/home.jsp" class="btn btn-default">desistir</a>
          <button type="submit" class="btn btn-danger">continuar</button>
        </div>
      </section>
    </form>

  </article>
  <footer></footer>
</body>

<%-- JS --%>
<jsp:include page="/template/common/js.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/passagem/cancelar.js"></script>

</html>
