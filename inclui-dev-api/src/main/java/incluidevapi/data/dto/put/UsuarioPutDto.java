package incluidevapi.data.dto.put;

import incluidevapi.component.validation.constraint.UsuarioExistsById;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPutDto {
    @NotNull @NotEmpty @UsuarioExistsById
    private UUID id;

    @NotNull @NotEmpty
    private String nome, senha, perfil, referenciaFoto;

    @NotNull @NotEmpty @Email
    private String email;
}