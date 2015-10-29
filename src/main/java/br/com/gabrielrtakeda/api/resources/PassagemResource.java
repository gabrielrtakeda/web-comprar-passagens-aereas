package br.com.gabrielrtakeda.api.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.gabrielrtakeda.to.AeronaveTO;
import br.com.gabrielrtakeda.api.beans.ComprarPassagemBean;
import br.com.gabrielrtakeda.to.PassagemTO;
import br.com.gabrielrtakeda.to.PassageiroTO;
import br.com.gabrielrtakeda.model.PassagemModel;

@Path("passagem")
public class PassagemResource {

    @GET
    @Path("/bilhete/{bilhete}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByBilhete(
        @PathParam("bilhete") String bilhete
    ) {
        PassagemModel model = new PassagemModel();
        PassagemTO passagemTO = model.getByBilhete(bilhete);
        return new Gson().toJson(passagemTO);
    }

    @GET
    @Path("/calculo-valor/{tipoPassageiro}/{valor}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getListByCodigo(
        @PathParam("tipoPassageiro") String tipoPassageiro,
        @PathParam("valor") double valor
    ) {
        PassagemModel model = new PassagemModel();
        double valorAtualizado = model.calculateValorPassagem(
            tipoPassageiro,
            valor
        );
        return Double.toString(valorAtualizado);
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String put(String comprarPassagemBeanJSON) {
        ComprarPassagemBean comprarPassagemBean = new Gson().fromJson(
            comprarPassagemBeanJSON,
            ComprarPassagemBean.class
        );

        PassagemModel model = new PassagemModel();
        List<PassageiroTO>
            insertedPassageiroTOList = model.insert(comprarPassagemBean);

        if (insertedPassageiroTOList.size() > 0) {
            System.out.println("PassagemResource: put()");
            System.out.println("insertedPassageiroTOList: id");
            for (PassageiroTO passageiroBean : insertedPassageiroTOList) {
                System.out.println(passageiroBean.getId());
            }
        }

        return new Gson().toJson(comprarPassagemBean);
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public String postVoo(
        @FormParam("id") int id,
        @FormParam("vooId") int vooId
    ) {
        System.out.println("PassagemResource.postVoo()");
        System.out.println("id");
        System.out.println(id);
        PassagemModel model = new PassagemModel();
        PassagemTO to = model.updateVoo(id, vooId);

        return new Gson().toJson(to);
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public String delete(@PathParam("id") int id) {
        System.out.println("PassagemResource.delete()");
        System.out.println("id");
        System.out.println(id);
        PassagemTO to = new PassagemModel().delete(id);
        return new Gson().toJson(to);
    }
}
