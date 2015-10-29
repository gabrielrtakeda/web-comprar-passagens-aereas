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
  <title>Alterar Vôo</title>

  <%-- CSS --%>
  <jsp:include page="/template/common/css.jsp" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/voo.css" />
</head>

<body>
  <jsp:include page="/template/common/background.jsp" />

  <header data-active="voo">
    <div class="jumbotron">
      <div class="container">
        <h1>Alterar Vôo</h1>
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


      <%-- Vôo: Consultar --%>
      <jsp:include page="/voo/partials/consultar-form.jsp" />
      <jsp:include page="/voo/partials/consultar-table.jsp" />

      <section id="voo-alterar-container" class="hide">
        <%-- Vôo: Alterar --%>
        <form id="alterar-voo"
          action="${pageContext.request.contextPath}/api/voo"
          method="POST">
          <input id="voo-id" type="hidden" name="id" required />
          <input id="aeronave-id" type="hidden" name="aeronaveId" required />
          <input id="submit-form" type="submit" class="hidden" />

          <div class="container">
            <div class="row">
              <h2>Alterar</h2>
              <h4>Vôo</h4>
              <div class="col-md-3 col-sm-12">
                <div class="form-group">
                  <label for="input-codigo-voo">Código</label>
                  <input id="input-codigo-voo"
                    type="text"
                    class="form-control"
                    placeholder="Ex: JG58"
                    name="codigo"
                    required
                  />
                </div>
              </div>

              <div class="col-md-3 col-sm-12">
                <div class="form-group">
                  <label for="input-voo-situacao">Situação</label>
                  <select id="input-voo-situacao"
                      class="form-control"
                      name="situacao"
                      required>
                      <option value="">Selecione...</option>
                      <option value="Em espera">Em espera</option>
                      <option value="Confirmado">Confirmado</option>
                      <option value="Encerrado">Encerrado</option>
                  </select>
                </div>
              </div>

              <div class="col-md-3 col-sm-12">
                <div class="form-group">
                  <label for="voo-cadastrar-datetimepicker">Data e Hora</label>
                  <input id="voo-cadastrar-datetimepicker"
                    type="text"
                    class="form-control"
                    name="datahora"
                    placeholder="Formato: YYYY-MM-DD HH:mm:ss"
                    required
                  />
                </div>
              </div>

              <div class="col-md-3 col-sm-12">
                <div class="form-group">
                  <label for="input-voo-escalas">Escalas</label>
                  <input id="input-voo-escalas"
                    type="text"
                    class="form-control"
                    placeholder="Ex: 1 (quantidade)"
                    name="escalas"
                    required
                  />
                </div>
              </div>
            </div> <%-- /row --%>

            <div class="row">
              <div class="col-md-6 col-sm-12">
                <div class="form-group">
                  <label for="origem-aeroporto-list">Origem</label>
                  <select id="origem-aeroporto-list" name="origemAeroportoId" class="form-control" required>
                    <option value="">Selecione...</option>
                    <option value="1">Curitiba - Afonso Pena</option>
                    <option value="2">Natal - Augusto Severo</option>
                    <option value="3">Maceió - Campo dos Palmares</option>
                    <option value="4">Foz do Iguaçu-PR - Catarata</option>
                    <option value="5">Belo Horizonte - Confins</option>
                    <option value="6">São Paulo - Congonhas</option>
                    <option value="7">São Paulo - Cumbica</option>
                    <option value="8">Acre - Cruzeiro do Sul</option>
                  </select>
                </div>
              </div>

              <div class="col-md-6 col-sm-12">
                <div class="form-group">
                  <label for="destino-aeroporto-list">Destino</label>
                  <select id="destino-aeroporto-list"
                      name="destinoAeroportoId"
                      class="form-control"
                      required>
                    <option value="">Selecione...</option>
                    <option value="1">Curitiba - Afonso Pena</option>
                    <option value="2">Natal - Augusto Severo</option>
                    <option value="3">Maceió - Campo dos Palmares</option>
                    <option value="4">Foz do Iguaçu-PR - Catarata</option>
                    <option value="5">Belo Horizonte - Confins</option>
                    <option value="6">São Paulo - Congonhas</option>
                    <option value="7">São Paulo - Cumbica</option>
                    <option value="8">Acre - Cruzeiro do Sul</option>
                  </select>
                </div>
              </div>
            </div> <%-- /row --%>

            <div class="row">
              <div class="col-md-3 col-sm-12">
                  <div class="form-group">
                    <label for="voo-valor">Valor</label>
                    <input id="voo-valor"
                        type="text"
                        class="form-control"
                        placeholder="Ex: R$ 90,00"
                        name="valor"
                        required
                    />
                  </div>
              </div>
            </div> <%-- /row --%>
          </div> <%-- /container --%>
        </form>

        <div class="container">
          <h4>Aeronave</h4>
          <jsp:include page="/aeronave/partials/consultar-codigo-table-dataonly.jsp" />
          <jsp:include page="/aeronave/partials/consultar-table-dataonly.jsp" />
        </div> <%-- /container --%>

        <div class="row">
          <div class="col-md-12 text-right">
            <a href="${pageContext.request.contextPath}/home.jsp"
              class="btn btn-default">
              cancelar
            </a>
            <label for="submit-form" class="btn btn-primary">alterar</label>
          </div>
        </div> <%-- /row --%>
      </section>

    </div> <%-- /container --%>
  </article>

  <footer></footer>

</body>

<%-- JS --%>
<jsp:include page="/template/common/js.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/helper/AeronaveConsultaHelper.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/voo.js"></script>

</html>
