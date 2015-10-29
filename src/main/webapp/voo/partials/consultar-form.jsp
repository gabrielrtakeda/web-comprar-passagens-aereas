<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<form id="consultar-voo"
  method="GET"
  class="form-inline form-voo">

  <div class="row">
    <h2>Consultar</h2>
    <div class="col-md-8 col-sm-12">
      <div class="form-group">
        <label class="sr-only" for="input-consulta-codigo-aeronave">Vôo</label>
        <input id="input-consulta-codigo-aeronave"
          type="text"
          class="form-control"
          placeholder="Código do vôo"
          name="codigo"
          required
          autofocus
        />
      </div>
      <button type="submit" class="btn btn-primary">consultar</button>
    </div>
  </div>
</form> <%-- /consultar-voo --%>
