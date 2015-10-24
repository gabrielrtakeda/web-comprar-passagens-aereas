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

import br.com.gabrielrtakeda.model.AeronaveModel;
import br.com.gabrielrtakeda.to.AeronaveTO;

@Path("aeronave")
public class AeronaveResource {

    @GET
    @Path("/list/{codigo}")
    @Produces("application/json")
    public String getListByCodigo(
        @PathParam("codigo") String codigo
    ) {
        AeronaveModel model = new AeronaveModel();
        ArrayList<AeronaveTO> list = model.selectByCodigo(codigo);
        return new Gson().toJson(list);
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public String put(
        @FormParam("codigo") String codigo,
        @FormParam("nome") String nome,
        @FormParam("quantidadeFileiras") int quantidadeFileiras,
        @FormParam("quantidadeAssentosFileira") int quantidadeAssentosFileira
    ) {
        AeronaveModel model = new AeronaveModel();
        AeronaveTO to = model.insert(
            codigo,
            nome,
            quantidadeFileiras,
            quantidadeAssentosFileira
        );

        String response = "{}";
        if (to.getStatusOperation())
            response = "{\"status\": true, \"method\": \"PUT\"}";
        else
            response = "{\"status\": false, \"method\": \"PUT\"}";

        return response;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public String post(
        @FormParam("id") int id,
        @FormParam("codigo") String codigo,
        @FormParam("nome") String nome,
        @FormParam("quantidadeFileiras") int quantidadeFileiras,
        @FormParam("quantidadeAssentosFileira") int quantidadeAssentosFileira
    ) {
        AeronaveModel model = new AeronaveModel();
        AeronaveTO to = model.update(
            id,
            codigo,
            nome,
            quantidadeFileiras,
            quantidadeAssentosFileira
        );

        String response = "{}";
        if (to.getStatusOperation())
            response = "{\"status\": true, \"method\": \"POST\"}";
        else
            response = "{\"status\": false, \"method\": \"POST\"}";

        return response;
    }
}
