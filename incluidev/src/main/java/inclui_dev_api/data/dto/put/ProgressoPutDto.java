package inclui_dev_api.data.dto.put;

import inclui_dev_api.component.validation.constraint.ProgressoExistsById;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProgressoPutDto {
    @NotNull @NotEmpty @ProgressoExistsById
    private UUID id;

    @NotNull @PositiveOrZero
    private int progresso;
}