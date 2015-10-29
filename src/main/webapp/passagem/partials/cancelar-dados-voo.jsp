<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<section class="dados-voo container"
  data-voo-id="{{vooId}}"
  data-voo-codigo="{{vooCodigo}}"
  data-origem-aeroporto-id="{{origemAeroportoId}}"
  data-origem-aeroporto-nome="{{origemAeroportoNome}}"
  data-origem-aeroporto-nome-brief="{{origemAeroportoNomeBrief}}"
  data-destino-aeroporto-id="{{destinoAeroportoId}}"
  data-destino-aeroporto-nome="{{destinoAeroportoNome}}"
  data-destino-aeroporto-nome-brief="{{destinoAeroportoNomeBrief}}"
  data-voo-escalas-="{{vooEscalas}}"
  data-voo-situacao-="{{vooSituacao}}"
  data-voo-data-hora="{{vooDataHora}}"
  data-voo-valor="{{vooValor}}"
  data-voo-valor-text="{{vooValorText}}">
  <h3>Vôo</h3>

  <div class="row">
    <div class="col-md-2 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Código</label>
        <span class="form-control">{{vooCodigo}}</span>
      </div>
    </div>

    <div class="col-md-3 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Origem</label>
        <span class="form-control"
            data-tooltip="{{origemAeroportoNome}}"
            data-tooltip-stickto="top"
            data-tooltip-color="charcoal"
            data-tooltip-animate-function="spin">
          {{origemAeroportoNomeBrief}}
        </span>
      </div>
    </div>

    <div class="col-md-3 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Destino</label>
        <span class="form-control"
            data-tooltip="{{destinoAeroportoNome}}"
            data-tooltip-stickto="top"
            data-tooltip-color="charcoal"
            data-tooltip-animate-function="spin">
          {{destinoAeroportoNomeBrief}}
        </span>
      </div>
    </div>

    <div class="col-md-1 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Escalas</label>
        <span class="form-control">{{vooEscalas}}</span>
      </div>
    </div>

    <div class="col-md-3 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Situação</label>
        <span class="form-control">
          {{vooSituacao}}
        </span>
      </div>
    </div>
  </div> <%-- /row --%>

  <div class="row">
    <div class="col-md-4 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Data e hora</label>
        <span class="form-control">{{vooDataHora}}</span>
      </div>
    </div>

    <div class="col-md-3 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Valor</label>
        <span class="form-control">
          {{vooValorText}}
        </span>
      </div>
    </div>
  </div> <%-- /row --%>
</section>

<section class="dados-aeronave container"
  data-aeronave-id="{{aeronaveId}}"
  data-aeronave-codigo="{{aeronaveCodigo}}"
  data-aeronave-nome="{{aeronaveNome}}"
  data-aeronave-quantidade-fileiras="{{aeronaveQuantidadeFileiras}}"
  data-aeronave-quantidade-assentos-fileira="{{aeronaveQuantidadeAssentosFileira}}"
  data-aeronave-quantidade-total="{{aeronaveQuantidadeTotal}}">
  <h3>Aeronave</h3>

  <div class="row">
    <div class="col-md-2 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Código</label>
        <span class="form-control">{{aeronaveCodigo}}</span>
      </div>
    </div>

    <div class="col-md-4 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Nome</label>
        <span class="form-control">{{aeronaveNome}}</span>
      </div>
    </div>

    <div class="col-md-2 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Qtd. Fileiras</label>
        <span class="form-control">{{aeronaveQuantidadeFileiras}}</span>
      </div>
    </div>

    <div class="col-md-2 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Qtd. Assentos/Fil.</label>
        <span class="form-control">{{aeronaveQuantidadeAssentosFileira}}</span>
      </div>
    </div>

    <div class="col-md-2 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Qtd. Total</label>
        <span class="form-control">{{aeronaveQuantidadeTotal}}</span>
      </div>
    </div>
  </div> <%-- /row --%>
</section>

<section class="dados-passageiro container"
  data-passageiro-tipo-passageiro="{{passageiroTipoPassageiro}}"
  data-passageiro-forma-tratamento="{{passageiroFormaTratamento}}"
  data-passageiro-nome="{{passageiroNome}}"
  data-passageiro-sobrenome="{{passageiroSobrenome}}"
  data-passageiro-data-nascimento="{{passageiroDataNascimento}}">
  <h3>Passageiro</h3>

  <div class="row">
    <div class="col-md-2 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Tipo passageiro</label>
        <span class="form-control">{{passageiroTipoPassageiro}}</span>
      </div>
    </div>

    <div class="col-md-5 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Nome completo</label>
        <span class="form-control">
          {{passageiroFormaTratamento}} {{passageiroNome}} {{passageiroSobrenome}}
        </span>
      </div>
    </div>

    <div class="col-md-3 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Data de nascimento</label>
        <span class="form-control">{{passageiroDataNascimento}}</span>
      </div>
    </div>
  </div> <%-- /row --%>
</section>

<section class="dados-passageiro-responsavel container"
  data-passageiro-responsavel-tipo-passageiro="{{passageiroResponsavelTipoPassageiro}}"
  data-passageiro-responsavel-forma-tratamento="{{passageiroResponsavelFormaTratamento}}"
  data-passageiro-responsavel-nome="{{passageiroResponsavelNome}}"
  data-passageiro-responsavel-sobrenome="{{passageiroResponsavelSobrenome}}"
  data-passageiro-responsavel-data-nascimento="{{passageiroResponsavelDataNascimento}}"
  data-passageiro-responsavel-email="{{passageiroResponsavelEmail}}"
  data-passageiro-responsavel-ddd="{{passageiroResponsavelDdd}}"
  data-passageiro-responsavel-telefone="{{passageiroResponsavelTelefone}}">
  <h3>Passageiro Responsável</h3>

  <div class="row">
    <div class="col-md-2 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Tipo passageiro</label>
        <span class="form-control">{{passageiroResponsavelTipoPassageiro}}</span>
      </div>
    </div>

    <div class="col-md-5 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Nome completo</label>
        <span class="form-control">
          {{passageiroResponsavelFormaTratamento}}
          {{passageiroResponsavelNome}}
          {{passageiroResponsavelSobrenome}}
        </span>
      </div>
    </div>

    <div class="col-md-3 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Data de nascimento</label>
        <span class="form-control">{{passageiroResponsavelDataNascimento}}</span>
      </div>
    </div>
  </div> <%-- /row --%>

  <div class="row">
    <div class="col-md-4 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Email</label>
        <span class="form-control">{{passageiroResponsavelEmail}}</span>
      </div>
    </div>

    <div class="col-md-1 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">DDD</label>
        <span class="form-control">{{passageiroResponsavelDdd}}</span>
      </div>
    </div>

    <div class="col-md-4 col-sm-12">
      <div class="form-group">
        <label for="input-nome-aeronave">Telefone / Celular</label>
        <span class="form-control">{{passageiroResponsavelTelefone}}</span>
      </div>
    </div>
  </div> <%-- /row --%>
</section>
