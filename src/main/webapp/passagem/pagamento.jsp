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
  <title>Forma de Pagamento</title>

  <%-- CSS --%>
  <jsp:include page="/template/common/css.jsp" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/passagem/forma-pagamento.css" />
</head>

<body>
  <jsp:include page="/template/common/background.jsp" />

  <header data-active="passagem">
    <div class="jumbotron">
      <div class="container">
        <h1>Forma de Pagamento</h1>
        <small id="clock"></small>
      </div>
    </div>

    <jsp:include page="/template/common/header.jsp" />
  </header>

  <article>
    <section class="container">

      <%-- Alerts --%>
      <jsp:include page="/alert/error.jsp" />
      <jsp:include page="/alert/success.jsp" />

      <h2>Passagens</h2>

      <!-- <%-- Seleção de Tipo de Passageiro --%> -->
      <div class="container">
        <div class="row">

          <div class="responsive-tables col-md-4">
            <h4>Adultos</h4>
            <table id="adultos" class="table table-bordered table-hover">
              <thead>
                <tr>
                  <th>Dados pessoais</th>
                  <th>Valor</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
          </div>

          <div class="responsive-tables col-md-4">
            <h4>Crianças</h4>
            <table id="criancas" class="table table-bordered table-hover">
              <thead>
                <tr>
                  <th>Dados pessoais</th>
                  <th>Valor</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
          </div>

          <div class="responsive-tables col-md-4">
            <h4>Bebês</h4>
            <table id="bebes" class="table table-bordered table-hover">
              <thead>
                <tr>
                  <th>Dados pessoais</th>
                  <th>Valor</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
          </div>

        </div> <!-- /row -->
      </div> <!-- /container -->
    </section><!--  <%-- /container --%> -->

    <section class="container">
      <h2>Total</h2>

      <div class="container">
        <div class="row">

          <div class="responsive-tables col-md-6">
            <h4>Dados</h4>
            <table id="subtotal" class="table table-bordered table-hover">
              <thead>
                <tr>
                  <th>Tipo de passageiro</th>
                  <th>Valor/unidade</th>
                  <th>Quantidade</th>
                  <th>Subtotal</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
          </div> <!-- /col-md-6 -->

          <div class="responsive-tables col-md-3">
            <h4>Valor final</h4>
            <table id="total" class="table table-bordered table-hover">
              <thead>
                <tr>
                  <th>Total</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
          </div> <!-- /col-md-6 -->

        </div>
      </div>
    </section>

    <section class="container forma-pagamento">
      <h2>Forma de pagamento</h2>

      <div class="container">
        <div class="row">
          <h4><a href="#" class="forma-pagamento-selection">Cartão de crédito</a></h4>
          <ul class="hide">
            <li>
              <input id="radio-credito-amex" type="radio" name="formaPagamento" data-type="credito" value="amex" />
              <label for="radio-credito-amex"><img src="${pageContext.request.contextPath}/images/forma-pagamento/credito/amex-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-aura" type="radio" name="formaPagamento" data-type="credito" value="aura" />
              <label for="radio-credito-aura"><img src="${pageContext.request.contextPath}/images/forma-pagamento/credito/aura-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-banrisul" type="radio" name="formaPagamento" data-type="credito" value="banrisul" />
              <label for="radio-credito-banrisul"><img src="${pageContext.request.contextPath}/images/forma-pagamento/credito/banrisul-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-brasilcard" type="radio" name="formaPagamento" data-type="credito" value="brasilcard" />
              <label for="radio-credito-brasilcard"><img src="${pageContext.request.contextPath}/images/forma-pagamento/credito/brasilcard-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-diners" type="radio" name="formaPagamento" data-type="credito" value="diners" />
              <label for="radio-credito-diners"><img src="${pageContext.request.contextPath}/images/forma-pagamento/credito/diners-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-elo" type="radio" name="formaPagamento" data-type="credito" value="elo" />
              <label for="radio-credito-elo"><img src="${pageContext.request.contextPath}/images/forma-pagamento/credito/elo-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-fortbrasil" type="radio" name="formaPagamento" data-type="credito" value="fortbrasil" />
              <label for="radio-credito-fortbrasil"><img src="${pageContext.request.contextPath}/images/forma-pagamento/credito/fortbrasil-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-hipercard" type="radio" name="formaPagamento" data-type="credito" value="hipercard" />
              <label for="radio-credito-hipercard"><img src="${pageContext.request.contextPath}/images/forma-pagamento/credito/hipercard-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-mastercard" type="radio" name="formaPagamento" data-type="credito" value="mastercard" />
              <label for="radio-credito-mastercard"><img src="${pageContext.request.contextPath}/images/forma-pagamento/credito/mastercard-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-oipaggo" type="radio" name="formaPagamento" data-type="credito" value="oipaggo" />
              <label for="radio-credito-oipaggo"><img src="${pageContext.request.contextPath}/images/forma-pagamento/credito/oipaggo-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-personalcard" type="radio" name="formaPagamento" data-type="credito" value="personalcard" />
              <label for="radio-credito-personalcard"><img src="${pageContext.request.contextPath}/images/forma-pagamento/credito/personalcard-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-pleno" type="radio" name="formaPagamento" data-type="credito" value="pleno" />
              <label for="radio-credito-pleno"><img src="${pageContext.request.contextPath}/images/forma-pagamento/credito/pleno-128px.png" /></label>
            </li>
            <li>
              <input id="radio-credito-visa" type="radio" name="formaPagamento" data-type="credito" value="visa" />
              <label for="radio-credito-visa"><img src="${pageContext.request.contextPath}/images/forma-pagamento/credito/visa-128px.png" /></label>
            </li>
          </ul>
        </div>

        <div class="row">
          <h4><a href="#" class="forma-pagamento-selection">Cartão de débito</a></h4>
          <ul class="hide">
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

      <section id="credito" class="container hide">
        <form id="dados-pagamento-credito"
          action="${pageContext.request.contextPath}/api/pagamento/credito"
          method="PUT">
          <input type="hidden" name="bandeira" />

          <div class="row">
            <div class="col-md-4">
              <div class="form-group">
                <label for="inputCodigoSelecao">Nome do titular do cartão</label>
                <input id="inputCodigoSelecao"
                  type="text"
                  class="form-control"
                  placeholder="Ex: GABRIEL R TAKEDA"
                  name="nomeTitular"
                  required
                />
              </div>
            </div> <!-- /col-md-4 -->

            <div class="col-md-4">
              <div class="form-group">
                <label for="inputCodigoSelecao">CPF</label>
                <input id="inputCodigoSelecao"
                  type="text"
                  class="form-control"
                  placeholder="Ex: 123.456.789-90"
                  name="cpf"
                  required
                />
              </div>
            </div> <!-- /col-md-4 -->
          </div> <!-- /row -->

          <div class="row">
            <div class="col-md-4">
              <div class="form-group">
                <label for="inputCodigoSelecao">Número do cartão</label>
                <input id="inputCodigoSelecao"
                  type="text"
                  class="form-control"
                  placeholder="Ex: 5555 6666 7777 8884"
                  name="numeroCartao"
                  required
                />
              </div>
            </div> <!-- /col-md-4 -->

            <div class="col-md-4">
              <div class="form-group">
                <label for="inputCodigoSelecao">Data de Validade</label>
                <div class="row">
                  <div class="col-md-4 col-xs-5">
                    <select class="form-control"
                      name="dataVencimentoMes"
                      required>
                      <option value="">Selecione...</option>
                      <option value="01">01</option>
                      <option value="02">02</option>
                      <option value="03">03</option>
                      <option value="04">04</option>
                      <option value="05">05</option>
                      <option value="06">06</option>
                      <option value="07">07</option>
                      <option value="08">08</option>
                      <option value="09">09</option>
                      <option value="10">10</option>
                      <option value="11">11</option>
                      <option value="12">12</option>
                    </select>
                  </div>
                  <div class="col-md-8 col-xs-7">
                    <select class="form-control"
                      name="dataVencimentoAno"
                      required>
                      <option value="">Selecione...</option>
                      <option value="2015">2015</option>
                      <option value="2016">2016</option>
                      <option value="2017">2017</option>
                      <option value="2018">2018</option>
                      <option value="2019">2019</option>
                      <option value="2020">2020</option>
                      <option value="2021">2021</option>
                      <option value="2022">2022</option>
                      <option value="2023">2023</option>
                      <option value="2024">2024</option>
                      <option value="2025">2025</option>
                      <option value="2026">2026</option>
                      <option value="2027">2027</option>
                      <option value="2028">2028</option>
                      <option value="2029">2029</option>
                      <option value="2030">2030</option>
                    </select>
                  </div>
                </div>
              </div>
            </div> <!-- /col-md-4 -->

            <div class="col-md-4">
              <div class="form-group">
                <label for="inputCodigoSelecao">Código de segurança</label>
                <input id="inputCodigoSelecao"
                  type="number"
                  class="form-control"
                  placeholder="Ex: 000"
                  name="codigoSeguranca"
                  pattern="[0-9]{3}"
                  required
                />
              </div>
            </div> <!-- /col-md-4 -->
          </div> <!-- /row -->

          <section class="btn-action-group text-right">
            <div class="row">
              <div class="col-md-12">
                  <a href="${pageContext.request.contextPath}/home.jsp"
                    class="btn btn-default">
                    cancelar
                  </a>
                  <button type="submit" class="btn btn-primary">finalizar</button>
              </div>
            </div> <!-- /row -->
          </section>

        </form>
      </section> <!-- /#credito -->

      <div id="debito" class="container hide">
        <form id="dados-pagamento-debito"
          action="${pageContext.request.contextPath}/api/pagamento/debito"
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
                    class="btn btn-default"
                  >
                    cancelar
                  </a>
                  <button type="submit" class="btn btn-primary">comprar</button>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/passagem/forma-pagamento.js"></script>

</html>
