<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<section class="passageiro-container"
  data-index="{{index}}"
  data-tipo-passageiro="{{tipoPassageiro}}">

  <input type="hidden"
    name="passagens[][voo][id]"
    value="{{vooId}}"
  />
  <input type="hidden"
    name="passagens[][responsavel]"
    value="false"
  />
  <input type="hidden"
    name="passagens[][valorPassagem]"
    value="{{valorPassagem}}"
  />
  <input type="hidden"
    name="passagens[][tipoPassageiro]"
    value="{{tipoPassageiro}}"
  />

  <header>
    <div class="row">
      <div class="col-md-9 col-sm-9 col-xs-9">
        <h3>
          Dados do passageiro
          <small>
            ({{tipoPassageiro}} - {{valorPassagemText}})
          </small>
        </h3>
      </div>
      <div class="col-md-3 col-sm-3 col-xs-3 text-right">
        <a class="btn btn-danger btn-sm remover-passageiro" title="Remover">
          <span class="glyphicon glyphicon-remove-sign"></span>
        </a>
      </div>
    </div>
  </header>
  <div class="row">
    <div class="col-md-3 col-sm-12">
        <div class="form-group">
            <label for="input-nome-aeronave">Forma de tratamento</label>
              <select id="input-nome-aeronave"
                class="form-control select-tipo-passagem"
                name="passagens[][formaTratamento]"
                required>
                <option value="">Selecione...</option>
                <option value="Sr.">Sr.</option>
                <option value="Sra.">Sra.</option>
                <option value="Srta.">Srta.</option>
              </select>
        </div>
    </div>

    <div class="col-md-3 col-sm-12">
        <div class="form-group">
          <label for="input-nome-aeronave">Nome</label>
          <input id="input-codigo-aeronave"
            type="text"
            class="form-control"
            placeholder="Ex: Gabriel"
            name="passagens[][nome]"
            required
          />
        </div>
    </div>

    <div class="col-md-3 col-sm-12">
        <div class="form-group">
          <label for="input-nome-aeronave">Sobrenome</label>
          <input id="input-codigo-aeronave"
            type="text"
            class="form-control"
            placeholder="Ex: Ramos Takeda"
            name="passagens[][sobrenome]"
            required
          />
        </div>
    </div>

    <div class="col-md-3 col-sm-12">
        <div class="form-group">
          <label>Data de nascimento</label>
          <input type="text"
            class="form-control voo-cadastrar-passageiro-nascimento-datetimepicker"
            name="passagens[][dataNascimento]"
            placeholder="Formato: YYYY-MM-DD"
            required
          />
        </div>
    </div>
  </div>
</section> <!-- /passageiro-container -->
