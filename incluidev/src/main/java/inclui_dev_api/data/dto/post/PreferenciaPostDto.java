package inclui_dev_api.data.dto.post;

import inclui_dev_api.component.validation.constraint.UsuarioExistsById;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PreferenciaPostDto {
    @NotNull
    private boolean visual, motora, auditiva, cognitiva, atencao, dislexia, autismo, sindromeDown;

    @NotNull @UsuarioExistsById
    private UUID usuario;
}