package inclui_mais_api.data.mapper;

import inclui_mais_api.data.dto.post.UsuarioPostDto;
import inclui_mais_api.data.model.persist.perfil.UsuarioModel;
import org.springframework.beans.BeanUtils;

public class UsuarioMapper {
    public static UsuarioModel toMapper(UsuarioPostDto objetoEntrada) {
        UsuarioModel objetoSaida = new UsuarioModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }    
}