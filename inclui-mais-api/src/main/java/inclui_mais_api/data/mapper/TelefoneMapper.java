package inclui_mais_api.data.mapper;

import inclui_mais_api.data.dto.post.TelefonePostDto;
import inclui_mais_api.data.model.persist.perfil.TelefoneModel;
import org.springframework.beans.BeanUtils;

public class TelefoneMapper {
    public static TelefoneModel toMapper(TelefonePostDto objetoEntrada) {
        TelefoneModel objetoSaida = new TelefoneModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }    
}