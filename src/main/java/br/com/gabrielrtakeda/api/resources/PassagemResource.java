// package br.com.gabrielrtakeda.api.resources;

// import javax.ws.rs.GET;
// import javax.ws.rs.PUT;
// import javax.ws.rs.POST;
// import javax.ws.rs.Path;
// import javax.ws.rs.Produces;
// import javax.ws.rs.Consumes;
// import javax.ws.rs.FormParam;
// import javax.ws.rs.PathParam;
// import javax.ws.rs.core.MediaType;

// import java.util.List;
// import java.util.ArrayList;

// import com.google.gson.Gson;

// import br.com.gabrielrtakeda.model.AeronaveModel;
// import br.com.gabrielrtakeda.to.AeronaveTO;
// import br.com.gabrielrtakeda.api.mappers.Test;
// import br.com.gabrielrtakeda.api.mappers.PassagemMapper;
// import br.com.gabrielrtakeda.api.mappers.PassageiroMapper;

// @Path("passagem")
// public class PassagemResource {

//     @POST
//     @Path("/set")
//     @Consumes(MediaType.APPLICATION_JSON)
//     @Produces(MediaType.TEXT_PLAIN)
//     public String setTest(Test someName) {
//         return "Hello "+ someName.getFirstname()+" nice to meet you.";
//     }
// }
