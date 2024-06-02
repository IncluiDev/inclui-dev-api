package incluidevapi.data.mapper;

import incluidevapi.data.dto.post.AulaPostDto;
import incluidevapi.data.dto.put.AulaPutDto;
import incluidevapi.data.model.persist.educacional.AulaModel;
import org.springframework.beans.BeanUtils;

public class AulaMapper {
    public static AulaModel toMapper(AulaPostDto objetoEntrada) {
        AulaModel objetoSaida = new AulaModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }

    public static AulaModel toMapper(AulaModel persistido, AulaPutDto atualizacao) {
        BeanUtils.copyProperties(atualizacao, persistido);
        return persistido;
    }
}