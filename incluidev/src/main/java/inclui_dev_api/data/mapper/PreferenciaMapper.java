package inclui_dev_api.data.mapper;

import inclui_dev_api.data.dto.post.PreferenciaPostDto;
import inclui_dev_api.data.dto.put.PreferenciaPutDto;
import inclui_dev_api.data.model.persist.perfil.PreferenciaModel;
import org.springframework.beans.BeanUtils;

public class PreferenciaMapper {
    public static PreferenciaModel toMapper(PreferenciaPostDto objetoEntrada) {
        PreferenciaModel objetoSaida = new PreferenciaModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }

    public static PreferenciaModel toMapper(PreferenciaModel persistido, PreferenciaPutDto atualizacao) {
        BeanUtils.copyProperties(atualizacao, persistido);
        return persistido;
    }
}