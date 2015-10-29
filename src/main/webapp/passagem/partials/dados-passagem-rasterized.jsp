<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<div class="row">
  <div class="container">
    <div class="col-md-2 col-sm-12">
        <div class="form-group">
          <label for="input-nome-aeronave">#</label>
          <span class="form-control">{{id}}</span>
        </div>
    </div>

    <div class="col-md-5 col-sm-12">
        <div class="form-group">
          <label for="input-nome-aeronave">Aeroporto Origem</label>
          <span class="form-control">{{origemAeroportoNome}}</span>
        </div>
    </div>

    <div class="col-md-5 col-sm-12">
        <div class="form-group">
          <label for="input-nome-aeronave">Aeroporto Origem</label>
          <span class="form-control">{{destinoAeroportoNome}}</span>
        </div>
    </div>

    <div class="col-md-2 col-sm-12">
        <div class="form-group">
          <label for="input-nome-aeronave">Tipo</label>
          <span class="form-control">{{tipoPassageiro}}</span>
        </div>
    </div>

    <div class="col-md-5 col-sm-12">
        <div class="form-group">
          <label for="input-nome-aeronave">Passageiro</label>
          <span class="form-control">
            {{formaTratamento}} {{nome}} {{sobrenome}}
          </span>
        </div>
    </div>

    <div class="col-md-5 col-sm-12">
        <div class="form-group">
          <label for="input-nome-aeronave">Passageiro Responsável</label>
          <span class="form-control">
            {{formaTratamentoPassageiroResponsavel}}
            {{nomePassageiroResponsavel}}
            {{sobrenomePassageiroResponsavel}}
          </span>
        </div>
    </div>
  </div>
</div>
