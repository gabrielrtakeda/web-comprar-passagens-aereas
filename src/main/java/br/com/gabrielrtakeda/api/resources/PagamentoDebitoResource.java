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

import br.com.gabrielrtakeda.api.beans.CartaoDebitoBean;
import br.com.gabrielrtakeda.model.CartaoDebitoModel;
import br.com.gabrielrtakeda.to.CartaoDebitoTO;

@Path("pagamento/debito")
public class PagamentoDebitoResource {

    Gson gson = new Gson();

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String putDebito(String cartaoDebitoBeanJSON)
    {
        CartaoDebitoBean cartaoDebitoBean = gson.fromJson(
            cartaoDebitoBeanJSON,
            CartaoDebitoBean.class
        );

        CartaoDebitoModel cartaoDebitoModel = new CartaoDebitoModel();
        CartaoDebitoTO cartaoDebitoTO = cartaoDebitoModel
                .insert(cartaoDebitoBean);

        return new Gson().toJson(cartaoDebitoTO);
    }
}
