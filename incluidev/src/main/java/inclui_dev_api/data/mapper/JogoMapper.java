package inclui_dev_api.data.mapper;

import inclui_dev_api.data.dto.post.JogoPostDto;
import inclui_dev_api.data.dto.put.JogoPutDto;
import inclui_dev_api.data.model.persist.educacional.JogoModel;
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