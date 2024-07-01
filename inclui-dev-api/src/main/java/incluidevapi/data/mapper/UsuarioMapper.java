package incluidevapi.data.mapper;

import incluidevapi.data.dto.post.UsuarioPostDto;
import incluidevapi.data.dto.put.UsuarioPutDto;
import incluidevapi.data.model.persist.perfil.UsuarioModel;
import incluidevapi.data.model.type.PerfilTipo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioMapper {
    public static UsuarioModel toMapper(UsuarioPostDto objetoEntrada) {
        UsuarioModel objetoSaida = new UsuarioModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);

        objetoSaida.setPerfil(PerfilTipo.toString(objetoEntrada.getPerfil()));
        objetoSaida.setSenha(encode(objetoEntrada.getSenha()));

        return objetoSaida;
    }

    public static UsuarioModel toMapper(UsuarioModel persistido, UsuarioPutDto atualizacao) {
        BeanUtils.copyProperties(atualizacao, persistido);
        persistido.setSenha(encode(atualizacao.getSenha()));

        return persistido;
    }

    private static String encode(String senha) {
        return new BCryptPasswordEncoder().encode(senha);
    }
}