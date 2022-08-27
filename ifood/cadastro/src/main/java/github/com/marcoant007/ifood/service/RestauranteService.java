package github.com.marcoant007.ifood.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import github.com.marcoant007.ifood.models.Restaurante;
import github.com.marcoant007.ifood.repository.RestauranteRepository;

@ApplicationScoped
public class RestauranteService {

    @Inject
    RestauranteRepository restauranteRepository;

    public List<Restaurante> findAllRestaurantes() {
        List<Restaurante> restaurantes = restauranteRepository.findAll().list();
        return restaurantes;
    }

    public Restaurante createRestaurante(Restaurante restauranteDTO) {
        restauranteRepository.persist(restauranteDTO);
        return restauranteDTO;
    }

    
    
}
