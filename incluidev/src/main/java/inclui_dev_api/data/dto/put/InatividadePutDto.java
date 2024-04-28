package inclui_dev_api.data.dto.put;

import inclui_dev_api.component.validation.constraint.InatividadeExistsById;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class InatividadePutDto {
    @NotNull @NotEmpty @InatividadeExistsById
    private UUID id;

    @NotNull
    private LocalDate ultimoAcesso;
}