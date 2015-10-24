<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<div class="row">
  <h2>
    Passagens
    <small>
      (Adulto: <span id="quantidade-adulto">0</span>,
      Criança: <span id="quantidade-crianca">0</span>,
      Bebê: <span id="quantidade-bebe">0</span>)
    </small>
  </h2>

  <%-- Seleção de Tipo de Passageiro --%>
  <form id="select-tipo-passageiro">
    <div class="col-md-12 col-sm-12">
        <div class="form-group">
          <label for="input-nome-aeronave">Tipo</label>
          <div class="form-inline">
            <select id="select-passageiro-tipo"
              class="form-control select-tipo-passagem"
              name="tipoPassageiro"
              required >
              <option value="">Selecione...</option>
              <option value="Adulto">Adulto</option>
              <option value="Criança">Criança</option>
              <option value="Bebê">Bebê</option>
            </select>
            <button id="add-passageiro-button" type="submit" class="btn btn-success">
              <span class="glyphicon glyphicon-plus-sign"></span>
            </button>
          </div>
        </div>
    </div>
  </form>
</div>
