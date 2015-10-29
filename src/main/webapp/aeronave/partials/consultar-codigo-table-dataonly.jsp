<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<div class="row">
  <div class="col-md-4">
    <form id="consultar-aeronave"
      method="GET"
      class="form-inline">

      <div class="form-group">
        <label class="sr-only" for="input-codigo-aeronave">
          Código aeronave
        </label>
        <input id="input-codigo-aeronave"
          type="text"
          class="form-control"
          placeholder="Código aeronave"
          name="codigo"
          autofocus
        />
      </div>
      <button type="submit" class="btn btn-primary">consultar</button>

    </form>
  </div> <%-- /col-md-3 --%>
</div> <%-- /row --%>
