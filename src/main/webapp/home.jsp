<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Sistema de Passagens Aéreas</title>

  <%-- CSS --%>
  <jsp:include page="/template/common/css.jsp" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css" />
</head>

<body>
  <jsp:include page="/template/common/background.jsp" />

  <header>
    <div class="jumbotron">
      <div class="container">
        <h1>Seja bem vindo gabrieltakeda!</h1>
        <small id="clock"></small>
      </div>
    </div>

    <jsp:include page="/template/common/header.jsp" />
  </header>

  <section class="container alert-container">
    <jsp:include page="/alert/error.jsp" />
    <jsp:include page="/alert/success.jsp" />
  </section>
</body>

<%-- JS --%>
<jsp:include page="/template/common/js.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/home.js"></script>

</html>
