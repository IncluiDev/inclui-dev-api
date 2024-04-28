package inclui_dev_api.data.mapper;

import inclui_dev_api.data.dto.post.TelefonePostDto;
import inclui_dev_api.data.dto.put.TelefonePutDto;
import inclui_dev_api.data.model.persist.perfil.TelefoneModel;
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