package br.com.gabrielrtakeda.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;

import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;

import br.com.gabrielrtakeda.model.VooModel;
import br.com.gabrielrtakeda.to.VooTO;

@Path("voo")
public class VooResource {

    @GET
    @Path("/list/{quantidadePassageiros}/{origemAeroportoId}/{destinoAeroportoId}/{dataHora: (.+)?}")
    @Produces("application/json")
    public String getListDisponivel(
        @PathParam("quantidadePassageiros") int quantidadePassageiros,
        @PathParam("origemAeroportoId") int origemAeroportoId,
        @PathParam("destinoAeroportoId") int destinoAeroportoId,
        @PathParam("dataHora") String dataHora
    ) {
        ArrayList<VooTO> list = new ArrayList<VooTO>();
        System.out.println(dataHora);
        try {
            list = new VooModel().getListDisponivel(
                quantidadePassageiros,
                origemAeroportoId,
                destinoAeroportoId,
                dataHora
            );
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new Gson().toJson(list);
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public String put(
        @FormParam("aeronaveId") int aeronaveId,
        @FormParam("codigo") String codigo,
        @FormParam("situacao") String situacao,
        @FormParam("datahora") String datahora,
        @FormParam("escalas") String escalas,
        @FormParam("origem") int origem,
        @FormParam("destino") int destino,
        @FormParam("valor") double valor
    ) {
        String response = "{}";
        VooTO to = new VooTO();

        try {
            VooModel model = new VooModel();
            to = model.insert(
                aeronaveId,
                codigo,
                situacao,
                datahora,
                escalas,
                origem,
                destino,
                valor
            );
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        if (to.getStatusOperation())
            response = "{\"status\": true, \"method\": \"PUT\"}";
        else
            response = "{\"status\": false, \"method\": \"PUT\"}";

        return response;
    }

    // @POST
    // @Produces("application/json")
    // @Consumes("application/x-www-form-urlencoded")
    // public String post(
    //     @FormParam("id") String id,
    //     @FormParam("codigo") String codigo,
    //     @FormParam("nome") String nome,
    //     @FormParam("quantidadePassageiros") String quantidadePassageiros
    // ) {
    //     String response = "{}";

    //     System.out.println(id);
    //     System.out.println(codigo);
    //     System.out.println(nome);
    //     System.out.println(quantidadePassageiros);

    //     VooModel model = new VooModel();
    //     VooTO to = model.update(
    //         Integer.parseInt(id),
    //         codigo,
    //         nome,
    //         Integer.parseInt(quantidadePassageiros)
    //     );

    //     if (to.getStatusOperation())
    //         response = "{\"status\": true, \"method\": \"POST\"}";
    //     else
    //         response = "{\"status\": false, \"method\": \"POST\"}";

    //     return response;
    // }
}
