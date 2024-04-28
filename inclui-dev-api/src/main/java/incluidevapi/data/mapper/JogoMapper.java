package incluidevapi.data.mapper;

import incluidevapi.data.dto.post.JogoPostDto;
import incluidevapi.data.dto.put.JogoPutDto;
import incluidevapi.data.model.persist.educacional.JogoModel;
import org.springframework.beans.BeanUtils;

public class JogoMapper {
    public static JogoModel toMapper(JogoPostDto objetoEntrada) {
        JogoModel objetoSaida = new JogoModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }

    public static JogoModel toMapper(JogoModel persistido, JogoPutDto atualizacao) {
        BeanUtils.copyProperties(atualizacao, persistido);
        return persistido;
    }
}