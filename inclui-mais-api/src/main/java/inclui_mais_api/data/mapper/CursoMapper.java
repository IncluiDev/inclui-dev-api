package inclui_mais_api.data.mapper;

import inclui_mais_api.data.dto.post.CursoPostDto;
import inclui_mais_api.data.model.persist.educacional.CursoModel;
import org.springframework.beans.BeanUtils;

public class CursoMapper {
    public static CursoModel toMapper(CursoPostDto objetoEntrada) {
        CursoModel objetoSaida = new CursoModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }
}