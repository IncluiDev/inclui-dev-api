package inclui_dev_api.data.dto.post;

import inclui_dev_api.component.validation.constraint.UsuarioExistsById;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ResponsavelPostDto {
    @NotNull @NotEmpty
    private String nome, senha, perfil;

    @NotNull @NotEmpty @Email
    private String email;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull @UsuarioExistsById
    private UUID usuario;
}