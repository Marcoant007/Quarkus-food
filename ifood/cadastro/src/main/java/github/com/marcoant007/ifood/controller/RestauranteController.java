package github.com.marcoant007.ifood.controller;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import github.com.marcoant007.ifood.models.Restaurante;
import github.com.marcoant007.ifood.service.restaurante.RestauranteService;

@Path("/restaurantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestauranteController {

    @Inject
    RestauranteService restauranteService;
    
    @GET
    public List<Restaurante> findRestaurantes(){
        return restauranteService.findAllRestaurantes();
    }

    @GET
    @Path("{id}")
    public Restaurante findRestaurantebyId(@PathParam("id") Long id){
        return restauranteService.findRestauranteById(id);
    }

    @POST
    public ResponseBuilder adicionarRestaurante(Restaurante restauranteDTO) {
        Restaurante restaurante = restauranteService.createRestaurante(restauranteDTO);
        return Response.status(Status.CREATED).entity(restaurante);
    }

    @PUT
    @Path("{id}")
    public ResponseBuilder atualizarRestaurante(@PathParam("id") Long id, Restaurante restauranteDTO){
        Restaurante restaurante = restauranteService.atualizarRestaurante(id, restauranteDTO);
        return Response.status(Status.CREATED).entity(restaurante);
    }

    @PUT
    @Path("{id}")
    public Response deleteRestaurante(@PathParam("id") Long id){
        restauranteService.deletedRestaurante(id);
        return Response.status(Status.CREATED).build();
    }


}
