package inclui_dev_api.data.dto.post;

import inclui_dev_api.component.validation.constraint.UsuarioExistsById;
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