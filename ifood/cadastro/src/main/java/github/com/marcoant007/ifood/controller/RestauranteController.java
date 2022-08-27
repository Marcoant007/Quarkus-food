package github.com.marcoant007.ifood.controller;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
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
import github.com.marcoant007.ifood.service.RestauranteService;

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

    @POST
    @Transactional
    public ResponseBuilder adicionarRestauranteResponse(Restaurante restauranteDTO) {
        Restaurante restaurante = restauranteService.createRestaurante(restauranteDTO);
        return Response.status(Status.CREATED).entity(restaurante);
    }

    // @PUT
    // @Path("{id}")
    // @Transactional
    // public void atualizar(@PathParam("id") Long id, Restaurante restauranteDTO){
    //    Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(id);
    //     if(restauranteOp.isEmpty()){
    //         throw new NotFoundException();
    //     }
    //     Restaurante restaurante = restauranteOp.get();
    //     restaurante.nome = restauranteDTO.nome;
    //     restauranteDTO.persist();
    // }

    // @PUT
    // @Path("{id}")
    // @Transactional
    // public void delete(@PathParam("id") Long id){
    //     Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(id);
    //     restauranteOp.ifPresentOrElse(Restaurante ::delete, () -> {
    //         throw new NotFoundException();
    //     });
    // }

    // @GET
    // @Path("{idRestaurante}/pedidos")
    // public List<Restaurante> buscarPedidos(@PathParam("idRestaurante") Long idRestaurante){
    //     Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);
    //     if(restauranteOp.isEmpty()){
    //         throw new NotFoundException("Restaurante não existe");
    //     }
    //     return Pedido.list("restaurante", restauranteOp.get());
    // }

    // @POST
    // @Path("{idRestaurante}/pedidos")
    // @Transactional
    // public ResponseBuilder adicionarPedidos(@PathParam("idRestaurante") Long idRestaurante, Pedido pedidosDTO){
    //     Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);
    //     if(restauranteOp.isEmpty()){
    //         throw new NotFoundException("Restaurante não existe");
    //     }
    //     Pedido pedido = new Pedido();
    //     pedido.nome = pedidosDTO.nome;
    //     pedido.descricao =  pedidosDTO.descricao;
    //     pedido.preco = pedidosDTO.preco;
    //     pedido.restaurante = restauranteOp.get();
    //     pedido.persist();;
    //     return Response.status(Status.CREATED).entity(pedido);
    // }

    // @PUT
    // @Path("{idRestaurante}/pedidos/{id}")
    // public ResponseBuilder atualizarPedidos(@PathParam("idRestaurante") Long idRestaurante, @PathParam("id") Long id , Pedido pedidosDTO ){
    //     Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);
    //     if(restauranteOp.isEmpty()){
    //         throw new NotFoundException("Restaurante não existe");
    //     }
    //     Optional<Pedido> pedidoOp = Pedido.findByIdOptional(id);
    //     if(pedidoOp.isEmpty()){
    //         throw new NotFoundException("Pedido não existe");
    //     }
    //     Pedido pedido = pedidoOp.get();
    //     pedido.preco = pedidosDTO.preco;
    //     pedido.persist();
        
    //     return  Response.status(Status.CREATED).entity(pedido);
    // }

    // @DELETE
    // @Path("{idRestaurante}/pedidos/{id}")
    // public void deletarPedidos(@PathParam("idRestaurante") Long idRestaurante, @PathParam("id") Long id){
    //     Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);
    //     if(restauranteOp.isEmpty()){
    //         throw new NotFoundException("Restaurante não existe");
    //     }
    //     Optional<Pedido> pedidoOp = Pedido.findByIdOptional(id);
    //     pedidoOp.ifPresentOrElse(Pedido::delete, ()-> {
    //         throw new NotFoundException();
    //     });
    // }
}
