package incluidevapi.data.mapper;

import incluidevapi.data.dto.post.TelefonePostDto;
import incluidevapi.data.dto.put.TelefonePutDto;
import incluidevapi.data.model.persist.perfil.TelefoneModel;
import org.springframework.beans.BeanUtils;

public class TelefoneMapper {
    public static TelefoneModel toMapper(TelefonePostDto objetoEntrada) {
        TelefoneModel objetoSaida = new TelefoneModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }

    public static TelefoneModel toMapper(TelefoneModel persistido, TelefonePutDto atualizacao) {
        BeanUtils.copyProperties(atualizacao, persistido);
        return persistido;
    }
}