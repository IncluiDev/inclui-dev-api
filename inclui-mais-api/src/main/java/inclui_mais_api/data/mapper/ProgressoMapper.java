package inclui_mais_api.data.mapper;

import inclui_mais_api.data.dto.post.ProgressoPostDto;
import inclui_mais_api.data.model.persist.usabilidade.ProgressoModel;
import org.springframework.beans.BeanUtils;

public class ProgressoMapper {
    public static ProgressoModel toMapper(ProgressoPostDto objetoEntrada) {
        ProgressoModel objetoSaida = new ProgressoModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }    
}