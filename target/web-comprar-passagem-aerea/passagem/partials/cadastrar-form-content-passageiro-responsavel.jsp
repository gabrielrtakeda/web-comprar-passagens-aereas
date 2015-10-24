<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<section class="passageiro-container"
  data-index="{{index}}"
  data-tipo-passageiro="{{tipoPassageiro}}">

  <input type="hidden"
    name="passageiro[][responsavel]"
    value="true"
  />
  <input type="hidden"
    name="passageiro[][tipoPassageiro]"
    value="{{tipoPassageiro}}"
  />

  <header>
    <div class="row">
      <div class="col-md-12">
        <h3>Dados do passageiro <small>(Adulto - responsável pela compra)</small></h3>
      </div>
    </div>
  </header>
  <div class="row">
    <div class="col-md-3 col-sm-12">
        <div class="form-group">
            <label for="input-nome-aeronave">Forma de tratamento</label>
              <select id="input-nome-aeronave"
                class="form-control select-tipo-passagem"
                name="passageiro[][formaTratamento]"
                required>
                <option value="">Selecione...</option>
                <option value="Em espera">Sr.</option>
                <option value="Confirmado">Sra.</option>
                <option value="Encerrado">Srta.</option>
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
            name="passageiro[][nome]"
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
            name="passageiro[][sobrenome]"
            required
          />
        </div>
    </div>

    <div class="col-md-3 col-sm-12">
        <div class="form-group">
          <label>Data de nascimento</label>
          <input type="text"
            class="form-control voo-cadastrar-passageiro-nascimento-datetimepicker"
            name="passageiro[][dataNascimento]"
            placeholder="Formato: YYYY-MM-DD"
            required
          />
        </div>
    </div>
  </div>

  <div class="row">
    <div class="col-md-6 col-sm-12">
        <div class="form-group">
          <label>Email</label>
          <input type="email"
            class="form-control passageiro-email"
            name="passageiro[][email]"
            placeholder="Ex: nome@domain.com.br"
            required
          />
        </div>
    </div>

    <div class="col-md-2 col-sm-12">
        <div class="form-group">
          <label>DDD</label>
          <input type="text"
            class="form-control passageiro-ddd"
            name="passageiro[][ddd]"
            placeholder="Ex: 11"
            pattern="[0-9]{2}"
            required
          />
        </div>
    </div>

    <div class="col-md-4 col-sm-12">
        <div class="form-group">
          <label>Telefone/Celular</label>
          <input type="text"
            class="form-control passageiro-telefone"
            name="passageiro[][telefone]"
            placeholder="Ex: 97777-7777"
            pattern="[0-9]{4}-[0-9]{4,5}"
            required
          />
        </div>
    </div>
  </div> <!-- /row -->
</section> <!-- /passageiro-container -->
