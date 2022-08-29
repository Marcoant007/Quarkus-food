package github.com.marcoant007.ifood.repository;

import javax.enterprise.context.ApplicationScoped;

import github.com.marcoant007.ifood.models.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class PedidosRepository implements PanacheRepositoryBase<Pedido, Long> {
    
}
