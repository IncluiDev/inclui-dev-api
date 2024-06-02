package incluidevapi.data.dto.put;

import incluidevapi.component.validation.constraint.TelefoneExistsById;
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
public class TelefonePutDto {
    @NotNull @NotEmpty @TelefoneExistsById
    private UUID id;

    @NotNull @NotEmpty
    private String regiao, ddd, numero, tipo;
}