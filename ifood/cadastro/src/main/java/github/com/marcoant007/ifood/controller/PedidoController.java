// package github.com.marcoant007.ifood.controller;

// import java.util.List;

// import javax.inject.Inject;
// import javax.ws.rs.Consumes;
// import javax.ws.rs.GET;
// import javax.ws.rs.Path;
// import javax.ws.rs.PathParam;
// import javax.ws.rs.Produces;
// import javax.ws.rs.core.MediaType;

// import github.com.marcoant007.ifood.models.Restaurante;
// import github.com.marcoant007.ifood.service.restaurante.RestauranteService;

// @Path("/restaurantes")
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
// public class PedidoController {

//     @Inject
//     RestauranteService restauranteService;

//     // @GET
//     // @Path("{idRestaurante}/pedidos")
//     // public List<Restaurante> buscarPedidos(@PathParam("idRestaurante") Integer id){
        
//     // }


//         // @GET
//     // @Path("{idRestaurante}/pedidos")
//     // public List<Restaurante> buscarPedidos(@PathParam("idRestaurante") Long idRestaurante){
//     //     Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);
//     //     if(restauranteOp.isEmpty()){
//     //         throw new NotFoundException("Restaurante não existe");
//     //     }
//     //     return Pedido.list("restaurante", restauranteOp.get());
//     // }

//     // @POST
//     // @Path("{idRestaurante}/pedidos")
//     // @Transactional
//     // public ResponseBuilder adicionarPedidos(@PathParam("idRestaurante") Long idRestaurante, Pedido pedidosDTO){
//     //     Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);
//     //     if(restauranteOp.isEmpty()){
//     //         throw new NotFoundException("Restaurante não existe");
//     //     }
//     //     Pedido pedido = new Pedido();
//     //     pedido.nome = pedidosDTO.nome;
//     //     pedido.descricao =  pedidosDTO.descricao;
//     //     pedido.preco = pedidosDTO.preco;
//     //     pedido.restaurante = restauranteOp.get();
//     //     pedido.persist();;
//     //     return Response.status(Status.CREATED).entity(pedido);
//     // }

//     // @PUT
//     // @Path("{idRestaurante}/pedidos/{id}")
//     // public ResponseBuilder atualizarPedidos(@PathParam("idRestaurante") Long idRestaurante, @PathParam("id") Long id , Pedido pedidosDTO ){
//     //     Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);
//     //     if(restauranteOp.isEmpty()){
//     //         throw new NotFoundException("Restaurante não existe");
//     //     }
//     //     Optional<Pedido> pedidoOp = Pedido.findByIdOptional(id);
//     //     if(pedidoOp.isEmpty()){
//     //         throw new NotFoundException("Pedido não existe");
//     //     }
//     //     Pedido pedido = pedidoOp.get();
//     //     pedido.preco = pedidosDTO.preco;
//     //     pedido.persist();
        
//     //     return  Response.status(Status.CREATED).entity(pedido);
//     // }

//     // @DELETE
//     // @Path("{idRestaurante}/pedidos/{id}")
//     // public void deletarPedidos(@PathParam("idRestaurante") Long idRestaurante, @PathParam("id") Long id){
//     //     Optional<Restaurante> restauranteOp = Restaurante.findByIdOptional(idRestaurante);
//     //     if(restauranteOp.isEmpty()){
//     //         throw new NotFoundException("Restaurante não existe");
//     //     }
//     //     Optional<Pedido> pedidoOp = Pedido.findByIdOptional(id);
//     //     pedidoOp.ifPresentOrElse(Pedido::delete, ()-> {
//     //         throw new NotFoundException();
//     //     });
//     // }
// }
