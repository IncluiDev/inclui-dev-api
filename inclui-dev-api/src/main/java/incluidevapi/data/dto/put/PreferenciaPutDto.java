package incluidevapi.data.dto.put;

import incluidevapi.component.validation.constraint.PreferenciaExistsById;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PreferenciaPutDto {
    @NotNull @NotEmpty @PreferenciaExistsById
    private UUID id;

    @NotNull
    private boolean visual, motora, auditiva, cognitiva, atencao, dislexia, autismo, sindromeDown;
}