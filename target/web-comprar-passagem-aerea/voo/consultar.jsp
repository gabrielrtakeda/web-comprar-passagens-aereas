<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*, java.text.*"%>
<%@page import="model.*, to.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="style1.css">
  <title>Consultar Voo</title>
</head>
<body>
  <div id="page-wrapper">
    <div class="row">
      <div class="col-lg-12">
        <h1 class="page-header">Consultar Voo</h1>
      </div> <!-- /.col-lg-12 -->
    </div> <!-- /.row -->

    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-default">
          <div class="panel-heading">
            Dados do Voo
          </div>

          <form name="formulario"action="ConsultaVoo" method="post">
            <div class="panel-body">
              <div class="row">
                <div class="col-lg-6">
                  <form role="form">
                    <div class="form-group">
                      <td>
                        <label for="senha">Tipo:</label>
                        <td>
                          <select size="1" name="Combo">
                            <option selected  class="form-control" value="Selecione">Selecione!</option>
                            <option value="2000">Código</option>
                            <option value="2001">Status</option>
                            <option value="2001">Origem</option>
                            <option value="2001">Destino</option>
                          </select>
                          <br />
                        </td>
                        <td>
                          <label for="senha">Filtro:</label>
                        </td>
                        <td>
                          <input class="form-control" NAME="Filtro">
                        </td>
                          <div class="container">

                            <table class="table table-condensed">
                              <thead>
                                <tr>
                                  <th>Status</th>
                                  <th>Horário</th>
                                  <th>Origem</th>
                                  <th>Destino</th>
                                </tr>
                              </thead>
                              <tbody>
                                <%
                                int ids;
                                String situacao;
                                String dataHora;
                                String origem;
                                String destino;
                                Voo voos = new Voo();
                                VooTO vt = new VooTO();
                                vt.voo = (ArrayList<Voo>)request.getSession().getAttribute("lstVoo");
                                for( int i = 0; i < vt.voo.size(); i++) {
                                voos = vt.voo.get(i);
                                ids = voos.getId();
                                situacao = voos.getSituacao();
                                dataHora = voos.getData();
                                origem = voos.getOrigem();
                                destino = voos.getDestino();
                                %>

                                <tr class="odd gradeX">

                                  <td><%=ids%></td>
                                  <td><%=situacao%></td>
                                  <td><%=dataHora%></td>
                                  <td><%=origem%></td>
                                  <td><%=destino%></td>
                                  <td><a href ="editarVoo.jsp?id = <%=ids%>&situacao = <%=situacao%>&dataHora=<%=dataHora%>&origem=<%=origem%>&destino=<%=destino%>">editar</a></td>
                                  <td><a href ="deletaVoo.jsp?id = <%=ids%>">deletar</a></td>
                                </tr>
                                <% } %>
                              </tbody>
                            </table>
                          </table>
                        </div>
                      </form>
                      <div class="footer">
                        <input type="button" name="botao" class="btn btn-default" value="Comprar"/>


                      </div> <!-- /.col-lg-6 (nested) -->
                    </div> <!-- /.row (nested) -->
                  </div>
                </form> <!-- /.panel-body -->
              </div> <!-- /.panel -->
            </div> <!-- /.col-lg-12 -->
          </div> <!-- /.row -->
        </div> <!-- /#page-wrapper -->

</body>
</html>
