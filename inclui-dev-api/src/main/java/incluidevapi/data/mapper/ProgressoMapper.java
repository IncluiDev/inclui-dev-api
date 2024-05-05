package incluidevapi.data.mapper;

import incluidevapi.data.dto.post.ProgressoPostDto;
import incluidevapi.data.dto.put.ProgressoPutDto;
import incluidevapi.data.model.persist.usabilidade.ProgressoModel;
import org.springframework.beans.BeanUtils;

public class ProgressoMapper {
    public static ProgressoModel toMapper(ProgressoPostDto objetoEntrada) {
        ProgressoModel objetoSaida = new ProgressoModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }

    public static ProgressoModel toMapper(ProgressoModel persistido, ProgressoPutDto atualizacao) {
        BeanUtils.copyProperties(atualizacao, persistido);
        return persistido;
    }
}