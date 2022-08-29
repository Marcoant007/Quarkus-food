package github.com.marcoant007.ifood.service.restaurante;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import github.com.marcoant007.ifood.models.Localizacao;
import github.com.marcoant007.ifood.models.Restaurante;
import github.com.marcoant007.ifood.repository.LocalizacaoRepository;
import github.com.marcoant007.ifood.repository.RestauranteRepository;

@ApplicationScoped
public class RestauranteService {

    @Inject
    RestauranteRepository restauranteRepository;

    @Inject
    LocalizacaoRepository localizacaoRepository;

    public List<Restaurante> findAllRestaurantes() {
        List<Restaurante> restaurantes = restauranteRepository.findAll().list();
        return restaurantes;
    }

    @Transactional
    public Restaurante createRestaurante(Restaurante restauranteDTO) {
        restauranteRepository.persist(restauranteDTO);
        Localizacao localizacao = restauranteDTO.getLocalizacao();
        localizacaoRepository.persist(localizacao);
        return restauranteDTO;
    }

    @Transactional
    public Restaurante atualizarRestaurante(Long id, Restaurante restauranteDTO) {
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
    public void deletedRestaurante(Long id) {
        Optional<Restaurante> restauranteOp = restauranteRepository.findByIdOptional(id);
        restauranteOp.ifPresentOrElse(restauranteRepository ::delete, () -> {
            throw new NotFoundException();
        });
    }

    public Restaurante findRestauranteById(Long id) {
        Optional<Restaurante> restauranteOp = restauranteRepository.findByIdOptional(id);
        if(restauranteOp.isEmpty()){
            throw new NotFoundException();
        }
        return restauranteOp.get();
    }

    
    
}
