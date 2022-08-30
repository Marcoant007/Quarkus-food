package github.com.marcoant007.ifood.controller;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import github.com.marcoant007.ifood.models.Pedido;
import github.com.marcoant007.ifood.models.Restaurante;
import github.com.marcoant007.ifood.service.restaurante.RestauranteService;

@Path("/restaurantes")
public class RestauranteController {

    @Inject
    RestauranteService restauranteService;
    
    @GET
    public List<Restaurante> findRestaurantes(){
        return restauranteService.findAllRestaurantes();
    }

    @GET
    @Path("{id}")
    public Restaurante findRestaurantebyId(@PathParam("id") Integer id){
        return restauranteService.findRestauranteById(id);
    }

    @POST
    public Restaurante adicionarRestaurante(Restaurante restauranteDTO) {
        Restaurante restaurante = restauranteService.createRestaurante(restauranteDTO);
        return restaurante;
    }

    @PUT
    @Path("{id}")
    public Restaurante atualizarRestaurante(@PathParam("id") Integer id, Restaurante restauranteDTO){
        Restaurante restaurante = restauranteService.atualizarRestaurante(id, restauranteDTO);
        return restaurante;
    }

    @PUT
    @Path("{id}")
    public Response deleteRestaurante(@PathParam("id") Integer id){
        restauranteService.deletedRestaurante(id);
        return Response.status(Status.CREATED).build();
    }

    @GET
    @Path("{idRestaurante}/pedidos")
    public List<Pedido> buscarPedidos(@PathParam ("idRestaurante") Integer idRestaurante){
       return restauranteService.findPedidosByRestauranteId(idRestaurante);
    }

    @POST
    @Path("{idRestaurante}/pedidos")
    public Pedido adicionarPedido(@PathParam("idRestaurante") Integer idRestaurante, Pedido pedidoDTO){
        return restauranteService.adicionarPedidoRestaurante(idRestaurante, pedidoDTO);
    }

    @PUT
    @Path("{idRestaurante}/pedidos/{id}")
    public Pedido atualizarPedido(@PathParam("idRestaurante") Integer idRestaurante, @PathParam("id") Integer id, Pedido pedidosDTO){
        return restauranteService.atualizarPedidoRestaurante(idRestaurante, id, pedidosDTO);
    }

    @DELETE
    @Path("{idRestaurante}/pedidos/{id}")
    public void excluirPedidos(@PathParam("idRestaurante") Integer idRestaurante, @PathParam("id") Integer id){
        restauranteService.excluirPedidosRestaurante(idRestaurante, id);
    }

}
