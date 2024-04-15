package inclui_mais_api.data.dto.post;

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

    @NotNull
    private UUID usuario;
}