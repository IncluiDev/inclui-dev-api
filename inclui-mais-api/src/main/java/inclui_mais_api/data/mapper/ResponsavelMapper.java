package inclui_mais_api.data.mapper;

import inclui_mais_api.data.dto.post.ResponsavelPostDto;
import inclui_mais_api.data.model.persist.perfil.ResponsavelModel;
import org.springframework.beans.BeanUtils;

public class ResponsavelMapper {
    public static ResponsavelModel toMapper(ResponsavelPostDto objetoEntrada) {
        ResponsavelModel objetoSaida = new ResponsavelModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }    
}