package inclui_dev_api.data.mapper;

import inclui_dev_api.data.dto.post.UsuarioPostDto;
import inclui_dev_api.data.dto.put.UsuarioPutDto;
import inclui_dev_api.data.model.persist.perfil.UsuarioModel;
import org.springframework.beans.BeanUtils;

public class UsuarioMapper {
    public static UsuarioModel toMapper(UsuarioPostDto objetoEntrada) {
        UsuarioModel objetoSaida = new UsuarioModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }

    public static UsuarioModel toMapper(UsuarioModel persistido, UsuarioPutDto atualizacao) {
        BeanUtils.copyProperties(atualizacao, persistido);
        return persistido;
    }
}