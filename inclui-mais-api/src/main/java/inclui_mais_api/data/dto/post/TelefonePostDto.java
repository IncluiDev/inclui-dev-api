package inclui_mais_api.data.dto.post;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TelefonePostDto {
    @NotNull @NotEmpty
    private String regiao, ddd, numero, tipo;

    @NotNull
    private UUID usuario;
}