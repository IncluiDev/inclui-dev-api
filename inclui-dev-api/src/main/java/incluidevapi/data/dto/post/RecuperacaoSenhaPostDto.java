package incluidevapi.data.dto.post;

import incluidevapi.component.validation.constraint.UsuarioExistsByEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RecuperacaoSenhaPostDto {
    @NotNull @NotEmpty @Email @UsuarioExistsByEmail
    private String email;
}
