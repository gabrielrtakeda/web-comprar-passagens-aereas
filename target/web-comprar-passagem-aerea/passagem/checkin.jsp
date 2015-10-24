<!DOCTYPE html>
<head>
  <title>Checkin</title>
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
          <form method ="post" action = "Checkin">
            <div class="panel-body">
              <div class="row">
                <div class="col-lg-6">
                  <form role="form">
                    <div class="form-group">

                      <p class="bg-danger"> Tipo de Passagem </p>

                      <input type="radio" name = "normal" > Normal </label >
                      <input type="radio" name = "reserva" > Reserva </label >
                      <hr>
                      <tr> <td> <label for="numeroPassagem ">Numero da Passagem:</label>
                      </td><td> <input class="form-control" name="txtnumeroPassagem" class="txt"/> </td> </tr>



                      <tr> <td><label>Local</label>
                      </td> <td><select class="form-control" name = "Local" id = "local_checkin">

                    </select> </td> </tr>
                    <br />
                    <p class="bg-danger"> Tipo de Passageiro </p>

                    <hr>

                    <tr> <td><label>Nome</label>
                    </td> <td><input class="form-control" name="txtnomePassageiro" class="txt"/> </td> </tr>

                    <tr> <td><label>Sobrenome</label>
                    </td> <td><input class="form-control" name="txtsobrenomePassageiro" class="txt"/> </td> </tr>


                  </select> </td> </tr>
                  <tr> <td> <label for="Origem">Tipo de Passageiro:</label>
                  </td> <td> </td> <td><select class="form-control" name = "Tipo de Passageiro" id = "tipo_passageiro">

                  <option value = "Bebe">Bebe</option>
                  <option value = "Crianca">Criança</option>
                  <option value = "Adulto" >Adulto</option>
                </select> </td> </tr>


                <tr> <td><label>Data de Nascimento</label>
                </td> <td><input class="form-control" name="txtdataNascimento" class="txt"/> </td> </tr>

              </select> </td> </tr>
              <tr> <td> <label for="Origem">Forma de Tratamento:</label>
              </td> <td> </td> <td><select class="form-control" name = "Forma de Tratamento" id = "forma_tratamento   ">

              <option value = "Senhor">Senhor</option>
              <option value = "Senhora">Senhora</option>
              <option value = "Senhorita">Senhorita</option>
            </select> </td> </tr>
            <hr>

            <div>


            </div>
            <div class="footer">
              <button type="button" type="submit" class="btn btn-default">Salvar</button>
              <button type="button" class="btn btn-default" data-dismiss="modal">Sair</button>
              <button type="button" type="submit" class="btn btn-default" data-dismiss="modal">Alterar</button>



            </div>

          </div>

        </div>
      </div>

    </div>



  </body>
  </html>
