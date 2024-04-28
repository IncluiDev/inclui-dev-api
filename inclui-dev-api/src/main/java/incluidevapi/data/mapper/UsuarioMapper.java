package incluidevapi.data.mapper;

import incluidevapi.data.dto.post.UsuarioPostDto;
import incluidevapi.data.dto.put.UsuarioPutDto;
import incluidevapi.data.model.persist.perfil.UsuarioModel;
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