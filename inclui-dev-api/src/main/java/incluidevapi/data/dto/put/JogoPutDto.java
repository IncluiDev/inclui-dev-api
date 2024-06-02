package incluidevapi.data.dto.put;

import incluidevapi.component.validation.constraint.JogoExistsById;
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
public class JogoPutDto {
    @NotNull @NotEmpty @JogoExistsById
    private UUID id;

    @NotNull @NotEmpty
    private String nome;
}