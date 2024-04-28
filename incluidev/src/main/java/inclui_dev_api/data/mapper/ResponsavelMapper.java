package inclui_dev_api.data.mapper;

import inclui_dev_api.data.dto.post.ResponsavelPostDto;
import inclui_dev_api.data.dto.put.ResponsavelPutDto;
import inclui_dev_api.data.model.persist.perfil.ResponsavelModel;
import org.springframework.beans.BeanUtils;

public class ResponsavelMapper {
    public static ResponsavelModel toMapper(ResponsavelPostDto objetoEntrada) {
        ResponsavelModel objetoSaida = new ResponsavelModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }

    public static ResponsavelModel toMapper(ResponsavelModel persistido, ResponsavelPutDto atualizacao) {
        BeanUtils.copyProperties(atualizacao, persistido);
        return persistido;
    }
}