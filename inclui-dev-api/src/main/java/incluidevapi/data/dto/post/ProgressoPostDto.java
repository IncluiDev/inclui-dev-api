package incluidevapi.data.dto.post;

import incluidevapi.component.validation.constraint.UsuarioExistsById;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProgressoPostDto {
    @NotNull @PositiveOrZero
    private int progresso;

    @NotNull @NotEmpty
    private String modalidade;

    @NotNull
    private UUID educativo;

    @NotNull @UsuarioExistsById
    private UUID usuario;
}