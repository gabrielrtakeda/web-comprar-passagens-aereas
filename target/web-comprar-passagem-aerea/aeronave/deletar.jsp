<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/metisMenu.min.css" rel="stylesheet">
  <link href="css/dataTables.bootstrap.css" rel="stylesheet">
  <link href="css/dataTables.responsive.css" rel="stylesheet">
  <link href="css/sb-admin-2.css" rel="stylesheet">
  <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">

  <script async defer type="text/javascript">
    function mostraResult(){
      var url = window.location.toString();
      var aux = url.split("=");

      document.getElementById("id").value = aux[1];
    }
  </script>
</head>
<body onLoad = "mostraResult()" id="top">
  <div id="wrapper">
    <div id="page-wrapper">
      <div class="row">
        <div class="col-lg-12">
          <h1 class="page-header">Deletar Aeronave</h1>
        </div> <!-- /.col-lg-12 -->
      </div> <!-- /.row -->
      <div class="row">
        <div class="col-lg-12">
          <div class="panel panel-default">
            <div class="panel-heading">
              Remover?
              <form method ="post" action = "ExclusaoAeronave">
                <button  name = "salvar"type="submit" class="btn btn-default">Sim</button>
                <div style="visibility: hidden">
                  <label>Código </label>
                  <input class="form-control" id = "id" name="id" autofocus required = true>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
</body>
</html>
