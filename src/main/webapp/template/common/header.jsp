<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<div class="container">
  <ul class="nav nav-pills">
    <li role="presentation" class="dropdown aeronave">
      <a class="dropdown-toggle"
        data-toggle="dropdown"
        href="#"
        role="button"
        aria-haspopup="true"
        aria-expanded="false">
        Aeronave <span class="caret"></span>
      </a>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
        <li><a href="${pageContext.request.contextPath}/aeronave/cadastrar.jsp">Cadastrar</a></li>
        <li><a href="${pageContext.request.contextPath}/aeronave/consultar.jsp">Consultar</a></li>
      </ul>
    </li>

    <li role="presentation" class="dropdown voo">
      <a class="dropdown-toggle"
        data-toggle="dropdown"
        href="#"
        role="button"
        aria-haspopup="true"
        aria-expanded="false">
        Vôo <span class="caret"></span>
      </a>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
        <li><a href="${pageContext.request.contextPath}/voo/cadastrar.jsp">Cadastrar</a></li>
        <li><a href="${pageContext.request.contextPath}/voo/consultar.jsp">Consultar</a></li>
      </ul>
    </li>

    <li role="presentation" class="dropdown passagem">
      <a class="dropdown-toggle"
        data-toggle="dropdown"
        href="#"
        role="button"
        aria-haspopup="true"
        aria-expanded="false">
        Passagem <span class="caret"></span>
      </a>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
        <li><a href="${pageContext.request.contextPath}/passagem/comprar.jsp">Comprar</a></li>
        <li><a href="${pageContext.request.contextPath}/passagem/transferir.jsp">Tranferir</a></li>
        <li><a href="${pageContext.request.contextPath}/passagem/cancelar.jsp">Cancelar</a></li>
        <li><a href="${pageContext.request.contextPath}/passagem/checkin.jsp">Check-in</a></li>
      </ul>
    </li>

    <li role="presentation" class="dropdown vendas">
      <a class="dropdown-toggle"
        data-toggle="dropdown"
        href="#"
        role="button"
        aria-haspopup="true"
        aria-expanded="false">
        Vendas <span class="caret"></span>
      </a>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
        <li><a href="${pageContext.request.contextPath}/vendas/consultar.jsp">Consultar</a></li>
      </ul>
    </li>

    <li role="presentation" class="dropdown opcoes">
      <a class="dropdown-toggle"
        data-toggle="dropdown"
        href="#"
        role="button"
        aria-haspopup="true"
        aria-expanded="false">
        Opções <span class="caret"></span>
      </a>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
        <li><a href="#">Cadastrar</a></li>
        <li><a href="#">Alterar</a></li>
        <li><a href="#">Deletar</a></li>
        <li><a href="#">Consultar</a></li>
      </ul>
    </li>
  </ul>
</div>
