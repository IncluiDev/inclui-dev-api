package inclui_dev_api.data.dto.post;

import inclui_dev_api.component.validation.constraint.UsuarioExistsById;
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