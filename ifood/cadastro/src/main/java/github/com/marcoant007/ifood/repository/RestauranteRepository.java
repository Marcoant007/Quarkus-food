package github.com.marcoant007.ifood.repository;

import javax.enterprise.context.ApplicationScoped;

import github.com.marcoant007.ifood.models.Restaurante;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class RestauranteRepository implements PanacheRepositoryBase<Restaurante, Integer> {
    
}
