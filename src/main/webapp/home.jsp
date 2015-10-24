<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <title>Principal</title>
  <link rel="stylesheet" type="text/css" href="./node_modules/bootstrap/dist/css/bootstrap.min.css" />
  <link rel="stylesheet" type="text/css" href="./css/home.css" />
  <title>Sistema de Passagens Aéreas</title>
</head>

<body onload="DataHora()">
  <% String usuario = (String) request.getParameter("usuarioAutenticado"); %>

  <header>
    <div class="jumbotron">
      <div class="container">
        <h1>Seja bem vindo gabrieltakeda!</h1>
        <small id="tempo"></small>
      </div>
    </div>

    <div class="container">
      <ul class="nav nav-pills">
        <li role="presentation" class="dropdown active">
          <a class="dropdown-toggle"
            data-toggle="dropdown"
            href="#"
            role="button"
            aria-haspopup="true"
            aria-expanded="false"
          >
            Aeronave <span class="caret"></span>
          </a>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="aeronave/cadastrar.jsp">Cadastrar</a></li>
            <li><a href="aeronave/alterar.jsp">Alterar</a></li>
            <li><a href="aeronave/deletar.jsp">Deletar</a></li>
            <li><a href="aeronave/consultar.jsp">Consultar</a></li>
          </ul>
        </li>

        <li role="presentation" class="dropdown">
          <a class="dropdown-toggle"
            data-toggle="dropdown"
            href="#"
            role="button"
            aria-haspopup="true"
            aria-expanded="false"
          >
            Vôo <span class="caret"></span>
          </a>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="voo/cadastrar.jsp">Cadastrar</a></li>
            <li><a href="voo/alterar.jsp">Alterar</a></li>
            <li><a href="voo/deletar.jsp">Deletar</a></li>
            <li><a href="voo/consultar.jsp">Consultar</a></li>
          </ul>
        </li>

        <li role="presentation" class="dropdown">
          <a class="dropdown-toggle"
            data-toggle="dropdown"
            href="#"
            role="button"
            aria-haspopup="true"
            aria-expanded="false"
          >
            Passagem <span class="caret"></span>
          </a>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="passagem/comprar.jsp">Comprar</a></li>
            <li><a href="#">Alterar</a></li>
            <li><a href="#">Deletar</a></li>
            <li><a href="#">Consultar</a></li>
          </ul>
        </li>

        <li role="presentation" class="dropdown">
          <a class="dropdown-toggle"
            data-toggle="dropdown"
            href="#"
            role="button"
            aria-haspopup="true"
            aria-expanded="false"
          >
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
  </header>
  <article></article>
  <footer></footer>
</body>

  <script type="text/javascript" src="./node_modules/jquery/dist/jquery.min.js"></script>
  <script type="text/javascript" src="./node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./js/common.js"></script>
</html>
