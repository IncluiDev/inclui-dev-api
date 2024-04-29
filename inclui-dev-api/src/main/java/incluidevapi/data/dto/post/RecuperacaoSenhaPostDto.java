package incluidevapi.data.dto.put;

import lombok.Data;

@Data
public class RecuperacaoSenhaPutDto {
    private String email;
    private String senha, codigo;
}
