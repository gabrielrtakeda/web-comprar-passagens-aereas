package br.com.gabrielrtakeda.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
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
    @Path("/list/{quantidadePassageiros}/{origemAeroportoId}/{destinoAeroportoId}/{dataHora: (.+)}/")
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

    @GET
    @Path("/list-valor/{quantidadePassageiros}/{origemAeroportoId}/{destinoAeroportoId}/{valor}")
    @Produces("application/json")
    public String getListDisponivel(
        @PathParam("quantidadePassageiros") int quantidadePassageiros,
        @PathParam("origemAeroportoId") int origemAeroportoId,
        @PathParam("destinoAeroportoId") int destinoAeroportoId,
        @PathParam("valor") double valor
    ) {
        ArrayList<VooTO> list = new ArrayList<VooTO>();

        try {
            list = new VooModel().getListDisponivel(
                quantidadePassageiros,
                origemAeroportoId,
                destinoAeroportoId,
                valor
            );
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(new Gson().toJson(list));

        return new Gson().toJson(list);
    }

    @GET
    @Path("/list/{codigo}")
    @Produces("application/json")
    public String getListDisponivel(@PathParam("codigo") String codigo) {
        ArrayList<VooTO> list = new ArrayList<VooTO>();

        try {
            list = new VooModel().getListByCodigo(codigo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(new Gson().toJson(list));

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

    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public String post(
        @FormParam("id") int id,
        @FormParam("aeronaveId") int aeronaveId,
        @FormParam("codigo") String codigo,
        @FormParam("situacao") String situacao,
        @FormParam("datahora") String datahora,
        @FormParam("escalas") String escalas,
        @FormParam("origemAeroportoId") int origemAeroportoId,
        @FormParam("destinoAeroportoId") int destinoAeroportoId,
        @FormParam("valor") double valor
    ) {
        String response = "{}";
        VooTO to = new VooTO();

        try {
            to = new VooModel().update(
                id,
                aeronaveId,
                codigo,
                situacao,
                datahora,
                escalas,
                origemAeroportoId,
                destinoAeroportoId,
                valor
            );
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new Gson().toJson(to);
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public String delete(@PathParam("id") int id) {
        VooTO to = new VooTO();
        try { to = new VooModel().delete(id); }
        catch (Exception e) { e.printStackTrace(); }

        return new Gson().toJson(to);
    }
}
