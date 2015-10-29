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
  <title>Reembolso Passagem</title>

  <%-- CSS --%>
  <jsp:include page="/template/common/css.jsp" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/passagem/forma-pagamento.css" />
</head>

<body>
  <jsp:include page="/template/common/background.jsp" />

  <header data-active="passagem">
    <div class="jumbotron">
      <div class="container">
        <h1>Reembolso Passagem</h1>
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

    <section class="container forma-pagamento">
      <h2>Forma de pagamento</h2>

      <div class="container">

        <div class="row">
          <ul class="">
            <li>
              <input id="radio-credito-bancodobrasil" type="radio" name="formaPagamento" data-type="debito" value="bancodobrasil" />
              <label for="radio-credito-bancodobrasil"><img src="${pageContext.request.contextPath}/images/forma-pagamento/debito/bancodobrasil-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-bradesco" type="radio" name="formaPagamento" data-type="debito" value="bradesco" />
              <label for="radio-credito-bradesco"><img src="${pageContext.request.contextPath}/images/forma-pagamento/debito/bradesco-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-hsbc" type="radio" name="formaPagamento" data-type="debito" value="hsbc" />
              <label for="radio-credito-hsbc"><img src="${pageContext.request.contextPath}/images/forma-pagamento/debito/hsbc-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-itau" type="radio" name="formaPagamento" data-type="debito" value="itau" />
              <label for="radio-credito-itau"><img src="${pageContext.request.contextPath}/images/forma-pagamento/debito/itau-128px.png" /></label>
            </li>
          </ul>
        </div> <!-- /row -->

      </div> <!-- /container -->
    </section> <!-- /forma-pagamento -->

    <section class="container dados-pagamento hide">
      <header>
        <h2>Dados de pagamento</h2>
      </header>

      <div id="debito" class="container">
        <form id="dados-pagamento-debito"
          action="${pageContext.request.contextPath}/api/reembolso"
          method="PUT">
          <input type="hidden" name="banco" />

          <div class="row">
            <div class="col-md-2">
              <div class="form-group">
                <label for="inputCodigoSelecao">Agência</label>
                <input id="inputCodigoSelecao"
                  type="text"
                  class="form-control"
                  placeholder="Ex: 9999"
                  name="agencia"
                  required
                />
              </div>
            </div> <!-- /col-md-4 -->

            <div class="col-md-3">
              <div class="form-group">
                <label for="inputCodigoSelecao">Conta corrente</label>
                <input id="inputCodigoSelecao"
                  type="text"
                  class="form-control"
                  placeholder="Ex: 99999-9"
                  name="contaCorrente"
                  required
                />
              </div>
            </div> <!-- /col-md-4 -->
          </div> <!-- /row -->

          <div class="row">
            <div class="col-md-5">
              <div class="form-group">
                <label for="inputCodigoSelecao">Nome do titular</label>
                <input id="inputCodigoSelecao"
                  type="text"
                  class="form-control"
                  placeholder="Ex: GABRIEL R TAKEDA"
                  name="nomeTitular"
                  required
                />
              </div>
            </div> <!-- /col-md-5 -->

            <div class="col-md-3">
              <div class="form-group">
                <label for="inputCodigoSelecao">CPF</label>
                <input id="inputCodigoSelecao"
                  type="text"
                  class="form-control"
                  placeholder="Ex: 123.456.789-09"
                  name="cpf"
                  required
                />
              </div>
            </div> <!-- /col-md-3 -->

            <div class="col-md-2">
              <div class="form-group">
                <label for="inputCodigoSelecao">DDD</label>
                <input id="inputCodigoSelecao"
                  type="number"
                  class="form-control"
                  placeholder="Ex: 011"
                  name="ddd"
                  pattern="[0-9]{3}"
                  required
                />
              </div>
            </div> <!-- /col-md-2 -->

            <div class="col-md-2">
              <div class="form-group">
                <label for="inputCodigoSelecao">Telefone</label>
                <input id="inputCodigoSelecao"
                  type="text"
                  class="form-control"
                  placeholder="Ex: 9999-9999?9"
                  name="telefone"
                  pattern="[0-9]{4}-[0-9]{4,5}"
                  required
                />
              </div>
            </div> <!-- /col-md-2 -->
          </div> <!-- /row -->

          <section class="btn-action-group text-right">
            <div class="row">
              <div class="col-md-12">
                  <a href="${pageContext.request.contextPath}/home.jsp"
                    class="btn btn-default">
                    desistir
                  </a>
                  <button type="submit" class="btn btn-primary">confirmar</button>
              </div>
            </div> <!-- /row -->
          </section>

        </form>
      </div> <!-- /#credito -->
    </section>

  </article>
  <footer></footer>
</body>

<%-- JS --%>
<jsp:include page="/template/common/js.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/passagem/model/FormaPagamentoModel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/passagem/reembolso.js"></script>

</html>
