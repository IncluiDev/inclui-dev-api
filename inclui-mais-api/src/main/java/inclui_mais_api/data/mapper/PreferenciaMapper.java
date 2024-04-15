package inclui_mais_api.data.mapper;

import inclui_mais_api.data.dto.post.PreferenciaPostDto;
import inclui_mais_api.data.model.persist.perfil.PreferenciaModel;
import org.springframework.beans.BeanUtils;

public class PreferenciaMapper {
    public static PreferenciaModel toMapper(PreferenciaPostDto objetoEntrada) {
        PreferenciaModel objetoSaida = new PreferenciaModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }    
}