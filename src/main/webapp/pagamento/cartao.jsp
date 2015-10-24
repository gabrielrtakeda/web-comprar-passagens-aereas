<!DOCTYPE html>
<head>
  <title>Cartão de Crédito</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> <BODY BACKGROUND="Boeing.jpg">
</head>
<body>
  <div id="page-wrapper">
    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-default">

          <form method="post" action="credito" role="form">
            <div class="panel-body">
              <div class="row">
                <div class="col-lg-6">
                  <div class="form-group">
                    <table>
                      <tr>
                        <td><label for="valorPassagem ">Bandeira do Cartão:</label></td>
                        <td>
                          <select class="form-control" name="CartoesCred" id="cartao_credito">
                            <option value="Visa"> Visa </option>
                            <option value="Mastercard"> Mastercard </option>
                            <option value="Dinners"> Dinners </option>
                            <option value="American Express"> American Express</option>
                            <option value="Elo"> Elo </option>
                            <option value="Aura"> Aura </option>
                            <option value="Sorocred"> Sorocred </option>
                          </select>
                        </td>
                      </tr>
                      <tr>
                        <td><label for="numeroCartao">Numero do Cartão:</label></td>
                        <td><input class="form-control" name="txtnumCartao" class="txt" /></td>
                      </tr>
                      <tr>
                        <td><label for="codSeg ">Código de Segurança:</label></td>
                        <td><input class="form-control" name="txtcodSeg" class="txt" /></td>
                      </tr>
                      <tr>
                        <td><label for="dataValCart">Data de Validade:</label></td>
                        <td><input class="form-control" name="txtdataVal" class="txt" /></td>
                      </tr>
                      <tr>
                        <td><label for="nomePass">Nome:</label></td>
                        <td><input class="form-control" name="txtnomePass" class="txt" /></td>
                      </tr>
                    </table>
                    <hr />
                    <div class="footer">
                      <button type="button" type="submit" class="btn btn-success">Validar</button>
                      <button type="button" class="btn btn-danger">Sair</button>
                    </div> <!-- /.footer -->
                  </div> <!-- /.form-group -->
                </div> <!-- /.col-lg-6 -->
              </div> <!-- /.row -->
            </div> <!-- /.panel-body -->
          </form>

        </div> <!-- /.panel -->
      </div> <!-- /.col-lg-12 -->
    </div> <!-- /.row -->
  </div> <!-- /#page-wrapper -->
</body>
</html>
