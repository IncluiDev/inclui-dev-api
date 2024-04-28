package incluidevapi.data.mapper;

import incluidevapi.data.dto.post.EnderecoPostDto;
import incluidevapi.data.dto.put.EnderecoPutDto;
import incluidevapi.data.model.persist.perfil.EnderecoModel;
import org.springframework.beans.BeanUtils;

public class EnderecoMapper {
    public static EnderecoModel toMapper(EnderecoPostDto objetoEntrada) {
        EnderecoModel objetoSaida = new EnderecoModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);
        return objetoSaida;
    }

    public static EnderecoModel toMapper(EnderecoModel persistido, EnderecoPutDto atualizacao) {
        BeanUtils.copyProperties(atualizacao, persistido);
        return persistido;
    }
}