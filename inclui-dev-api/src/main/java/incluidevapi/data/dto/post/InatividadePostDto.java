package incluidevapi.data.dto.post;

import incluidevapi.component.validation.constraint.UsuarioExistsById;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class InatividadePostDto {
    @NotNull
    private LocalDate ultimoAcesso;

    @NotNull @UsuarioExistsById
    private UUID usuario;
}