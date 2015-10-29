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

import br.com.gabrielrtakeda.api.beans.CartaoCreditoBean;
import br.com.gabrielrtakeda.model.CartaoCreditoModel;
import br.com.gabrielrtakeda.to.CartaoCreditoTO;

@Path("pagamento/credito")
public class PagamentoCreditoResource {

    Gson gson = new Gson();

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String put(String cartaoCreditoBeanJSON)
    {
        CartaoCreditoBean cartaoCreditoBean = gson.fromJson(
            cartaoCreditoBeanJSON,
            CartaoCreditoBean.class
        );

        CartaoCreditoModel cartaoCreditoModel = new CartaoCreditoModel();
        CartaoCreditoTO cartaoCreditoTO = cartaoCreditoModel
                .insert(cartaoCreditoBean);

        return new Gson().toJson(cartaoCreditoTO);
    }
}
