package github.com.marcoant007.ifood.dto.restauranteDTO;

import org.modelmapper.ModelMapper;

import github.com.marcoant007.ifood.models.Localizacao;

public class LocalizacaoDTO {

    private Double latitute;

    private Double longitude;

    private RestauranteDTO restaurante;

    public static LocalizacaoDTO create(Localizacao localizacaoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(localizacaoDTO, LocalizacaoDTO.class);
    }


    public Double getLatitute() {
        return this.latitute;
    }

    public void setLatitute(Double latitute) {
        this.latitute = latitute;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public RestauranteDTO getRestaurante() {
        return this.restaurante;
    }

    public void setRestaurante(RestauranteDTO restaurante) {
        this.restaurante = restaurante;
    }

}
