<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<div class="row">
  <%-- Alerts --%>
  <jsp:include page="/alert/error.jsp" />
  <jsp:include page="/alert/success.jsp" />

  <h2>Alterar</h2>
  <form id="aeronave-alterar"
    action="${pageContext.request.contextPath}/api/aeronave"
    method="POST">

    <%-- Aeronave: Form Alterar --%>
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
