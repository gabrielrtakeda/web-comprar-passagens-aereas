<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<div class="row">
  <h2>Alterar</h2>
  <form id="alterar"
    action="${pageContext.request.contextPath}/api/aeronave"
    method="POST"
  >

    <div id="alterar-success-alert" class="alert alert-success hide" role="alert">
      <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
      <span class="sr-only">Success:</span>
    </div>

    <jsp:include page="/aeronave/partials/cadastrar-form-content.jsp" />
    <div class="col-md-12 text-right">
      <a href="${pageContext.request.contextPath}/home.jsp"
        class="btn btn-default">
        cancelar
      </a>
      <button type="submit" class="btn btn-primary">alterar</button>
    </div>
  </form>
</div> <!-- /row -->
