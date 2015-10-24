<%@ page language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="model.*, to.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" type="text/css" href="style1.css">
  <title>Consultar Aeronave</title>
</head>
<body>
  <div id="page-wrapper">
    <div class="row">
      <div class="col-lg-12">
        <h1 class="page-header">Consultar Aeronave</h1>
      </div> <!-- /.col-lg-12 -->
    </div> <!-- /.row -->

    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-default">
          <div class="panel-heading">
            Aeronave
          </div>

          <div class="panel-body">
            <div class="row">
              <div class="col-lg-6">
                <form role="form">
                  <div class="form-group">
                    <td><label for="senha">Tipo:</label>
                      <td> <select size="1" name="Combo">
                        <option selected  class="form-control" value="Selecione">Selecione!</option>
                        <option value="2000">Código</option>
                        <option value="2001">Nome</option>
                        <option value="2002">Quantidade de Assentos</option>
                      </select> </td>
                      <br />
                      <td> <label for="senha">Filtro:</label>
                        <td> <INPUT class="form-control" NAME="Filtro" autofocus> </td>


                        <div class="container">

                          <table class="table table-condensed" autofocus>
                            <thead>
                              <tr>
                                <th>Código</th>
                                <th>Nome</th>
                                <th>Quantidade de Assentos</th>
                              </tr>
                              <tbody>
                                <%
                                int ids;
                                String codA;
                                String nome;
                                int quant;
                                Aeronave aeros = new Aeronave();
                                AeronaveTO aero = new AeronaveTO();
                                aero.aeronave = (ArrayList<Aeronave>)request.getSession().getAttribute("lstAeronave");

                                for( int i = 0; i < aero.aeronave.size(); i++) {
                                aeros = aero.aeronave.get(i);
                                ids = aeros.getId();
                                codA = aeros.getcodigo();
                                nome = aeros.getnome();
                                quant = aeros.getQuant_assentos();
                                %>

                                <tr class="odd gradeX">
                                  <td><%=ids%></td>
                                  <td><%=codA%></td>
                                  <td><%=nome%></td>
                                  <td><%=quant%></td>
                                  <td><a href ="editarAernoave.jsp?id = <%=ids%>&cod = <%=codA%>&nome=<%=nome%>&quant=<%=quant%>">editar</a></td>
                                  <td><a href ="deletaAeronave.jsp?id = <%=ids%>">deletar</a></td>
                                </tr>
                                <% }
                                %>
                              </tbody>
                            </table>
                          </div>
                        </form>
                      </div> <!-- /.col-lg-6 (nested) -->
                    </div> <!-- /.row (nested) -->
                  </form>

                  <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
              </div>
              <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
          </div>
          <!-- /#page-wrapper -->

          <!-- jQuery -->
          <script src="js/jquery.min.js"></script>

          <!-- Bootstrap Core JavaScript -->
          <script src="js/bootstrap.min.js"></script>

          <!-- Metis Menu Plugin JavaScript -->
          <script src="js/metisMenu.min.js"></script>

          <!-- Custom Theme JavaScript -->
          <script src="js/sb-admin-2.js"></script>


          <script src="js/jquery.dataTables.min.js"></script>
          <script src="js/dataTables.bootstrap.min.js"></script>

        </body>
        </html>
