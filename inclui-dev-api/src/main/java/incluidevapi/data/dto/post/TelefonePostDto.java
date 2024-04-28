package incluidevapi.data.dto.post;

import incluidevapi.component.validation.constraint.UsuarioExistsById;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TelefonePostDto {
    @NotNull @NotEmpty
    private String regiao, ddd, numero, tipo;

    @NotNull @UsuarioExistsById
    private UUID usuario;
}