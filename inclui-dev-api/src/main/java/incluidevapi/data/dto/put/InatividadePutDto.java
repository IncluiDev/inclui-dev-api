package incluidevapi.data.dto.put;

import incluidevapi.component.validation.constraint.InatividadeExistsById;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InatividadePutDto {
    @NotNull @NotEmpty @InatividadeExistsById
    private UUID id;

    @NotNull
    private LocalDate ultimoAcesso;
}