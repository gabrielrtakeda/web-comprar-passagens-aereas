package br.com.gabrielrtakeda.api.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.gabrielrtakeda.api.beans.ReembolsoBean;
import br.com.gabrielrtakeda.model.ReembolsoModel;
import br.com.gabrielrtakeda.to.ReembolsoTO;

@Path("reembolso")
public class ReembolsoResource {

    Gson gson = new Gson();

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String put(String reembolsoJSON)
    {
        ReembolsoBean bean = gson.fromJson(reembolsoJSON, ReembolsoBean.class);
        ReembolsoTO reembolsoTO = new ReembolsoModel().insert(bean);
        return gson.toJson(reembolsoTO);
    }
}
