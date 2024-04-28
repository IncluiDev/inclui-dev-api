package incluidevapi.data.mapper;

import incluidevapi.data.dto.post.CursoPostDto;
import incluidevapi.data.dto.put.CursoPutDto;
import incluidevapi.data.model.persist.educacional.CursoModel;
import org.springframework.beans.BeanUtils;

public class CursoMapper {
    public static CursoModel toMapper(CursoPostDto objetoEntrada) {
        CursoModel objetoSaida = new CursoModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }

    public static CursoModel toMapper(CursoModel persistido, CursoPutDto atualizacao) {
        BeanUtils.copyProperties(atualizacao, persistido);
        return persistido;
    }
}