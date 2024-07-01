package incluidevapi.data.dto.put;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgressoPutDto {
    @NotNull @NotEmpty
    private UUID usuario, educativo;

    @NotNull @PositiveOrZero
    private int progresso;
}