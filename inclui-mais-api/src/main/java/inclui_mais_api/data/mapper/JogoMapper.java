package inclui_mais_api.data.mapper;

import inclui_mais_api.data.dto.post.JogoPostDto;
import inclui_mais_api.data.model.persist.educacional.JogoModel;
import org.springframework.beans.BeanUtils;

public class JogoMapper {
    public static JogoModel toMapper(JogoPostDto objetoEntrada) {
        JogoModel objetoSaida = new JogoModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }    
}