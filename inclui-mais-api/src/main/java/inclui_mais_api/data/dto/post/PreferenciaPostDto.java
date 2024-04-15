package inclui_mais_api.data.dto.post;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PreferenciaPostDto {
    @NotNull
    private boolean deficienciaVisual, deficienciaAuditiva, autismo, daltonismo, dificuldadeFala;

    @NotNull
    private UUID usuario;
}