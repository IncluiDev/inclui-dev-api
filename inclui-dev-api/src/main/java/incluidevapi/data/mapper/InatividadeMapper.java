package incluidevapi.data.mapper;

import incluidevapi.data.dto.post.InatividadePostDto;
import incluidevapi.data.dto.put.InatividadePutDto;
import incluidevapi.data.model.persist.usabilidade.InatividadeModel;
import org.springframework.beans.BeanUtils;

public class InatividadeMapper {
    public static InatividadeModel toMapper(InatividadePostDto objetoEntrada) {
        InatividadeModel objetoSaida = new InatividadeModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }

    public static InatividadeModel toMapper(InatividadeModel persistido, InatividadePutDto atualizacao) {
        BeanUtils.copyProperties(atualizacao, persistido);
        return persistido;
    }
}