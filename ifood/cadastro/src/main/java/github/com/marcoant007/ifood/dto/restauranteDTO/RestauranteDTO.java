package github.com.marcoant007.ifood.dto.restauranteDTO;

import org.modelmapper.ModelMapper;

import github.com.marcoant007.ifood.models.Restaurante;

public class RestauranteDTO {
    
    public static RestauranteDTO create(Restaurante restauranteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        RestauranteDTO restaurante = modelMapper.map(restauranteDTO, RestauranteDTO.class);
        restaurante.setLocalizacao(LocalizacaoDTO.create(restauranteDTO.getLocalizacao()));
        return restaurante;
    }
    
    private String proprietario;

    private String cnpj;

    private String nome;

    private String nomeFantasia;

    private LocalizacaoDTO localizacao;


    public String getProprietario() {
        return this.proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalizacaoDTO getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(LocalizacaoDTO localizacao) {
        this.localizacao = localizacao;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

}
