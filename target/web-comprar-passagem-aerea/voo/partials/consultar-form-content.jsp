<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<h2>Vôo</h2>
<div class="col-md-2 col-sm-12">
    <div class="form-group">
      <label for="input-nome-aeronave">Qtd. Passageiros</label>
      <input id="input-codigo-aeronave"
        type="number"
        class="form-control"
        placeholder="Ex: 3"
        name="quantidadePassageiros"
        required
        autofocus
      />
    </div>
</div>

<div class="col-md-3 col-sm-12">
    <div class="form-group">
      <label for="origem-aeroporto-list">Origem</label>
      <select id="origem-aeroporto-list"
        name="origemAeroportoId"
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

<div class="col-md-3 col-sm-12">
    <div class="form-group">
      <label for="origem-aeroporto-list">Destino</label>
      <select id="origem-aeroporto-list"
        name="destinoAeroportoId"
        class="form-control"
        required
      >
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

<div class="col-md-4 col-sm-12">
    <div class="form-group">
      <label for="origem-aeroporto-list">Data e Hora</label>
      <input id="voo-consultar-datetimepicker"
        type="text"
        class="form-control"
        name="dataHora"
        placeholder="Formato: YYYY-MM-DD HH:mm:ss"
        required
      />
    </div>
</div>
