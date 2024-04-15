package inclui_mais_api.data.mapper;

import inclui_mais_api.data.dto.post.EnderecoPostDto;
import inclui_mais_api.data.model.persist.perfil.EnderecoModel;
import org.springframework.beans.BeanUtils;

public class EnderecoMapper {
    public static EnderecoModel toMapper(EnderecoPostDto objetoEntrada) {
        EnderecoModel objetoSaida = new EnderecoModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }    
}