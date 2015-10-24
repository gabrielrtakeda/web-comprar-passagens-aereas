<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<input id="input-id-aeronave" type="hidden" name="id" />

<div class="col-md-3 col-sm-12">
    <div class="form-group">
      <label for="input-codigo-aeronave">Código da Aeronave</label>
      <input id="input-codigo-aeronave"
        type="text"
        class="form-control"
        placeholder="Ex: EMB"
        name="codigo"
      />
    </div>
</div>

<div class="col-md-3 col-sm-12">
    <div class="form-group">
      <label for="input-nome-aeronave">Nome</label>
      <select id="input-nome-aeronave" class="form-control" name="nome" >
        <option value="-">Selecione...</option>
        <option value="Airbus A300">Airbus A300</option>
        <option value="Airbus A330">Airbus A330</option>
        <option value="Boeing 717">Boeing 717</option>
        <option value="Boeing 747">Boeing 747</option>
        <option value="Embraer ERJ-140">Embraer ERJ-140</option>
        <option value="Embraer Legacy 500">Embraer Legacy 500</option>
        <option value="Fokker 100">Fokker 100</option>
      </select>
    </div>
</div>

<div class="col-md-3 col-sm-12">
    <div class="form-group">
      <label for="input-quantidade-fileiras-aeronave">Qtd. Fileiras</label>
      <input id="input-quantidade-fileiras-aeronave"
        type="text"
        class="form-control"
        placeholder="Ex: 6"
        name="quantidadeFileiras"
      />
    </div>
</div>

<div class="col-md-3 col-sm-12">
    <div class="form-group">
      <label for="input-quantidade-assentos-fileira-aeronave">Qtd. Assentos/Fileira</label>
      <input id="input-quantidade-assentos-fileira-aeronave"
        type="text"
        class="form-control"
        placeholder="Ex: 20"
        name="quantidadeAssentosFileira"
      />
    </div>
</div>
