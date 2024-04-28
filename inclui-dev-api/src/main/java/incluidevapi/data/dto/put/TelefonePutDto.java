package incluidevapi.data.dto.put;

import incluidevapi.component.validation.constraint.TelefoneExistsById;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TelefonePutDto {
    @NotNull @NotEmpty @TelefoneExistsById
    private UUID id;

    @NotNull @NotEmpty
    private String regiao, ddd, numero, tipo;
}