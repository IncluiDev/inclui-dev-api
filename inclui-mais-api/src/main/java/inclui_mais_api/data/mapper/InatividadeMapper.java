package inclui_mais_api.data.mapper;

import inclui_mais_api.data.dto.post.InatividadePostDto;
import inclui_mais_api.data.model.persist.usabilidade.InatividadeModel;
import org.springframework.beans.BeanUtils;

public class InatividadeMapper {
    public static InatividadeModel toMapper(InatividadePostDto objetoEntrada) {
        InatividadeModel objetoSaida = new InatividadeModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }    
}