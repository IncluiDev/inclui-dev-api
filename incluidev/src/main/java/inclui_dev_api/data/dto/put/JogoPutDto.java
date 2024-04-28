package inclui_dev_api.data.dto.put;

import inclui_dev_api.component.validation.constraint.JogoExistsById;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class JogoPutDto {
    @NotNull @NotEmpty @JogoExistsById
    private UUID id;

    @NotNull @NotEmpty
    private String nome;
}