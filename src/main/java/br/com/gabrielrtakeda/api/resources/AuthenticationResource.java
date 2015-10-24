package br.com.gabrielrtakeda.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.Consumes;

import java.util.List;
import java.util.ArrayList;

import br.com.gabrielrtakeda.model.AuthenticationModel;
import br.com.gabrielrtakeda.to.LoginTO;

@Path("authentication")
public class AuthenticationResource {

    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public String post(
        @FormParam("usuario") String usuario,
        @FormParam("senha") String senha
    ) {
        String response = "{}";
        AuthenticationModel model = new AuthenticationModel();
        LoginTO to = model.select(usuario, senha);

        if (model.authenticate(to))
            response = "{\"status\": true}";
        else
            response = "{\"status\": false}";

        return response;
    }
}
