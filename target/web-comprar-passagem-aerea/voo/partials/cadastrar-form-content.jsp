<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<div class="row">
  <h2>Vôo</h2>
  <div class="col-md-3 col-sm-12">
      <div class="form-group">
        <label for="input-codigo-aeronave">Código do Vôo</label>
        <input id="input-codigo-aeronave"
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
        <label for="input-nome-aeronave">Situação</label>
        <select id="input-nome-aeronave" class="form-control" name="situacao" required>
          <option value="">Selecione...</option>
          <option value="Em espera">Em espera</option>
          <option value="Confirmado">Confirmado</option>
          <option value="Encerrado">Encerrado</option>
        </select>
      </div>
  </div>

  <div class="col-md-3 col-sm-12">
      <div class="form-group">
          <label for="input-nome-aeronave">Data e Hora</label>
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
        <label for="input-nome-aeronave">Escalas</label>
        <input id="input-codigo-aeronave"
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
        <select id="origem-aeroporto-list" name="origem" class="form-control" required>
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
        <select id="destino-aeroporto-list" name="destino" class="form-control" required>
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
        <label for="valor">Valor</label>
        <input id="valor"
          type="text"
          class="form-control"
          placeholder="Ex: R$ 90,00"
          name="valor"
          required
        />
      </div>
  </div>
</div> <%-- /row --%>
