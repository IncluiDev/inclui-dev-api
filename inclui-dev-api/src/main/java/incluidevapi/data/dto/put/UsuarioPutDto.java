package incluidevapi.data.dto.put;

import incluidevapi.component.validation.constraint.UsuarioExistsById;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UsuarioPutDto {
    @NotNull @NotEmpty @UsuarioExistsById
    private UUID id;

    @NotNull @NotEmpty
    private String nome, senha, perfil;

    @NotNull @NotEmpty @Email
    private String email;
}