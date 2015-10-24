<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

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
    <title>Consultar Passagem</title>
</head>
<body>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Consultar Passagem</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">


                    <form name="formulario"action="ConsultaPassagem" method="post">

                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form">
                                        <div class="form-group">

                                           <table class="table table-condensed">
                                            <thead>
                                              <tr>
                                                <th>Numero da Passagem</th>
                                                <th>Código</th>
                                                <th>Valor</th>
                                                <th>Assentos</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                          <tr>
                                            <td>.</td>
                                            <td>.</td>
                                            <td>.</td>
                                            <d>.</td>
                                            </tr>
                                            <tr>
                                                <td>.</td>
                                                <td>.</td>
                                                <td>.</td>
                                            </tr>
                                            <tr>
                                                <td>.</td>
                                                <td>.</td>
                                                <td>.</td>
                                            </tr>
                                            <tr>
                                                <td>.</td>
                                                <td>.</td>
                                                <td>.</td>
                                            </tr>

                                        </tbody>
                                    </table>
                                </div>

                                <div class="footer">
                                   <input type="button" name="checkin"  type="submit"class="btn btn-default" value="Checkin"/>
                                   <input type="button" name="transferir"  type="submit"class="btn btn-default" value="Transferir"/>
                                   <input type="button" name="cancelar"  type="submit" class="btn btn-default" value="Cancelar"/>
                                   <input type="button" name="sair"  type="submit"class="btn btn-default" value="Sair"/>
                                   <input type="button" name="consultar"  type="submit" class="btn btn-default" value="Consultar"/>


                               </div>
                               <!-- /.col-lg-6 (nested) -->
                           </div>
                           <!-- /.row (nested) -->
                       </div>
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



</body>
</html>
