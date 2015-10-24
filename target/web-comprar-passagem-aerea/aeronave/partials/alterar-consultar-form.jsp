<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<div class="row">
  <h2>Consultar</h2>
  <form id="consultar"
    action="${pageContext.request.contextPath}/api/aeronave/list/"
    method="GET"
    class="form-inline"
  >
    <div class="form-group">
      <label class="sr-only" for="inputCodigoSelecao">Email address</label>
      <input id="inputCodigoSelecao"
        type="text"
        class="form-control"
        placeholder="Código"
        name="codigo"
        autofocus
      />
    </div>
    <button type="submit" class="btn btn-primary">consultar</button>
  </form>
  <div class="table-responsive"></div>
</div> <!-- /row -->
