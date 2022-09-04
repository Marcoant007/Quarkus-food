package github.com.marcoant007.ifood.service.restaurante;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import github.com.marcoant007.ifood.models.Pedido;
import github.com.marcoant007.ifood.models.Restaurante;
import github.com.marcoant007.ifood.repository.LocalizacaoRepository;
import github.com.marcoant007.ifood.repository.PedidosRepository;
import github.com.marcoant007.ifood.repository.RestauranteRepository;

@ApplicationScoped
public class RestauranteService {

    @Inject
    RestauranteRepository restauranteRepository;

    @Inject
    LocalizacaoRepository localizacaoRepository;

    @Inject
    PedidosRepository pedidosRepository;

    public List<Restaurante> findAllRestaurantes() {
        List<Restaurante> restaurantes = restauranteRepository.findAll().list();
        return restaurantes;
    }

    @Transactional
    public Restaurante createRestaurante(Restaurante restauranteDTO) {
        restauranteDTO.getLocalizacao().setRestaurante(restauranteDTO);
        restauranteRepository.persist(restauranteDTO);
        return restauranteDTO;
    }

    @Transactional
    public Restaurante atualizarRestaurante(Integer id, Restaurante restauranteDTO) {
        Optional<Restaurante> restauranteOP =  restauranteRepository.findByIdOptional(id);
        if(restauranteOP.isEmpty()){
            throw new NotFoundException();
        }
        Restaurante restaurante = restauranteOP.get();
        restaurante.setNome(restauranteDTO.getNome());
        restauranteRepository.persist(restaurante);
        return restaurante;
    }

    @Transactional
    public void deletedRestaurante(Integer id) {
        Optional<Restaurante> restauranteOp = restauranteRepository.findByIdOptional(id);
        restauranteOp.ifPresentOrElse(restauranteRepository ::delete, () -> {
            throw new NotFoundException();
        });
    }

    @Transactional
    public Restaurante findRestauranteById(Integer id) {
        Optional<Restaurante> restauranteOp = restauranteRepository.findByIdOptional(id);
        if(restauranteOp.isEmpty()){
            throw new NotFoundException();
        }
        return restauranteOp.get();
    }
   
    @Transactional
    public List<Pedido> findPedidosByRestauranteId(Integer idRestaurante) {
        Optional<Restaurante> restauranteOp = restauranteRepository.findByIdOptional(idRestaurante);
        if(restauranteOp.isEmpty()){
            throw new NotFoundException("Restaurante não existe");
        }
        return pedidosRepository.list("restaurante", restauranteOp.get());
    }

    @Transactional
    public Pedido adicionarPedidoRestaurante(Integer idRestaurante, Pedido pedidoDTO) {
        Optional<Restaurante> restauranteOp = restauranteRepository.findByIdOptional(idRestaurante);
        if(restauranteOp.isEmpty()){
            throw new NotFoundException("Restaurante não existe");
        }
        Pedido pedido = new Pedido();
        pedido.setNome(pedidoDTO.getNome());
        pedido.setDescricao(pedidoDTO.getDescricao());
        pedido.setPreco(pedidoDTO.getPreco());
        pedido.setRestaurante(restauranteOp.get());
        pedidosRepository.persist(pedido);
        return pedido;
    }

    @Transactional
    public Pedido atualizarPedidoRestaurante(Integer idRestaurante, Integer idPedido, Pedido pedidosDTO) {
        Optional<Restaurante> restauranteOp = restauranteRepository.findByIdOptional(idRestaurante);
        if(restauranteOp.isEmpty()){
            throw new NotFoundException("Restaurante não existe");
        }
        Optional<Pedido> pedidoOp = pedidosRepository.findByIdOptional(idPedido);
        if(pedidoOp.isEmpty()){
            throw new NotFoundException("Pedido não existe");
        }
        Pedido pedido = pedidoOp.get();
        pedido.setPreco(pedidosDTO.getPreco());
        pedidosRepository.persist(pedido);
        return pedido;
    }

    @Transactional
    public void excluirPedidosRestaurante(Integer idRestaurante, Integer idPedido) {
        Optional<Restaurante> restauranteOp = restauranteRepository.findByIdOptional(idRestaurante);
        if(restauranteOp.isEmpty()){
            throw new NotFoundException("Restaurante não existe");
        }
        Optional<Pedido> pedidoOp = pedidosRepository.findByIdOptional(idPedido);
        pedidoOp.ifPresentOrElse(pedidosRepository :: delete, ()-> {
            throw new NotFoundException();
        });
    }

    
    
}
