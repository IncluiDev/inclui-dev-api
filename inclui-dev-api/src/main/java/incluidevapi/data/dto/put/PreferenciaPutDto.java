package incluidevapi.data.dto.put;

import incluidevapi.component.validation.constraint.PreferenciaExistsById;
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
public class PreferenciaPutDto {
    @NotNull @NotEmpty @PreferenciaExistsById
    private UUID id;

    @NotNull
    private boolean visual, motora, auditiva, cognitiva, atencao, dislexia, autismo, sindromeDown;
}