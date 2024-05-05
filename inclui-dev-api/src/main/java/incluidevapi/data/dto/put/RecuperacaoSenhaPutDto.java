package incluidevapi.data.dto.put;

import incluidevapi.component.validation.constraint.RecuperacaoSenhaExistsByEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RecuperacaoSenhaPutDto {
    @NotNull @NotEmpty @Email @RecuperacaoSenhaExistsByEmail
    private String email;

    @NotNull @NotEmpty
    private String senha, codigo;
}
