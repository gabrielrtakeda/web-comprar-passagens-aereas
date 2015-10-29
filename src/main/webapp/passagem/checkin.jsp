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
  <title>Check-in</title>

  <%-- CSS --%>
  <jsp:include page="/template/common/css.jsp" />
</head>

<body>
  <jsp:include page="/template/common/background.jsp" />

  <header data-active="passagem">
    <div class="jumbotron">
      <div class="container">
        <h1>Check-in</h1>
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

    <section class="container consulta-passagem">
      <form id="consultar-passagem"
        method="GET"
        class="form-inline">

        <div class="container">
          <div class="row">
            <h2>Passagem</h2>
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

    <section class="dados-passagem container">
      <h3>Dados da passagem</h3>
      <div class="content"></div>
    </section>

    <section class="alocar-assento container">
      <h3>Alocar assento</h3>

      <form id="transferir-passagem"
        action="${pageContext.request.contextPath}/api/passagem"
        method="POST">
        <input type="hidden" name="id" required />
        <input type="hidden" name="vooId" required />

        <div class="row">
          <div class="col-md-4 col-sm-12">
              <div class="form-group">
                <label for="input-nome-aeronave">Fileira</label>
                <select class="form-control" name="fileira">
                  <option value="">Selecione...</option>
                </select>
              </div>
          </div>

          <div class="col-md-4 col-sm-12">
              <div class="form-group">
                <label for="input-nome-aeronave">Assento</label>
                <select class="form-control" name="assento">
                  <option value="">Selecione...</option>
                </select>
              </div>
          </div>
        </div>

        <div class="row action-buttons">
          <div class="col-md-12 text-right">
            <button type="submit" class="btn btn-primary">transferir</button>
          </div>
        </div>
      </form>
    </section>

  </article>
  <footer></footer>
</body>

<%-- JS --%>
<jsp:include page="/template/common/js.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/passagem/checkin.js"></script>

</html>
