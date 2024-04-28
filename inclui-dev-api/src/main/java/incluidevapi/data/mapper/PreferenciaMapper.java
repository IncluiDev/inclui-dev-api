package incluidevapi.data.mapper;

import incluidevapi.data.dto.post.PreferenciaPostDto;
import incluidevapi.data.dto.put.PreferenciaPutDto;
import incluidevapi.data.model.persist.perfil.PreferenciaModel;
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