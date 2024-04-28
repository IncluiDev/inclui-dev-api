package inclui_dev_api.data.mapper;

import inclui_dev_api.data.dto.post.ProgressoPostDto;
import inclui_dev_api.data.dto.put.ProgressoPutDto;
import inclui_dev_api.data.model.persist.usabilidade.ProgressoModel;
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