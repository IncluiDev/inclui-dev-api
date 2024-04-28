package inclui_dev_api.data.mapper;

import inclui_dev_api.data.dto.post.InatividadePostDto;
import inclui_dev_api.data.dto.put.InatividadePutDto;
import inclui_dev_api.data.model.persist.usabilidade.InatividadeModel;
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