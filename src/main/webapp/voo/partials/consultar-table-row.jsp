<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<tr data-id="{{id}}"
    data-codigo="{{codigo}}"
    data-aeronave-id="{{aeronaveId}}"
    data-aeronave-codigo="{{aeronaveCodigo}}"
    data-aeronave-nome="{{aeronaveNome}}"
    data-origem-aeroporto-id="{{origemAeroportoId}}"
    data-origem-aeroporto-nome="{{origemAeroportoNome}}"
    data-destino-aeroporto-id="{{destinoAeroporotId}}"
    data-destino-aeroporto-nome="{{destinoAeroportoNome}}"
    data-situacao="{{situacao}}"
    data-data-hora="{{dataHora}}"
    data-escalas="{{escalas}}"
    data-valor="{{valor}}"
    data-valor-text="{{valorText}}">
  <td>{{aeronaveCodigo}}: {{aeronaveNome}}</td>
  <td data-tooltip="{{origemAeroportoNome}}"
      data-tooltip-stickto="top"
      data-tooltip-color="charcoal"
      data-tooltip-animate-function="spin">
      {{origemAeroportoNomeBrief}}
  </td>
  <td data-tooltip="{{destinoAeroportoNome}}"
      data-tooltip-stickto="top"
      data-tooltip-color="charcoal"
      data-tooltip-animate-function="spin">
      {{destinoAeroportoNomeBrief}}
  </td>
  <td>{{escalas}}</td>
  <td>{{dataHora}}</td>
  <td>{{situacao}}</td>
  <td>{{valorText}}</td>
  <td class="text-center">
    <button type="button"
      class="btn btn-danger btn-xs glyphicon glyphicon-remove-sign text-danger voo-delete"
      data-tooltip="Delete"
      data-tooltip-stickto="top"
      data-tooltip-color="charcoal"
      data-tooltip-animate-function="spin">
    </button>
  </td>
</tr>
