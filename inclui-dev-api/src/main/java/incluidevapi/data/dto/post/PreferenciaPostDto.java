package incluidevapi.data.dto.post;

import incluidevapi.component.validation.constraint.UsuarioExistsById;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreferenciaPostDto {
    @NotNull
    private boolean visual, motora, auditiva, cognitiva, atencao, dislexia, autismo, sindromeDown;

    @NotNull @UsuarioExistsById
    private UUID usuario;
}