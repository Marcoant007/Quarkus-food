package github.com.marcoant007.ifood.dto.restauranteDTO;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;

import github.com.marcoant007.ifood.models.Pedido;

public class PedidoDTO {
    
    private String nome;

    private String descricao;

    private RestauranteDTO restaurante;

    private BigDecimal preco;

    public static PedidoDTO create(Pedido pedido){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pedido, PedidoDTO.class);
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public RestauranteDTO getRestaurante() {
        return this.restaurante;
    }

    public void setRestaurante(RestauranteDTO restaurante) {
        this.restaurante = restaurante;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }


}
