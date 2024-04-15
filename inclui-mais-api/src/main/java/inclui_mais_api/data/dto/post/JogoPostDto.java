package inclui_mais_api.data.dto.post;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JogoPostDto {
    @NotNull @NotEmpty
    private String nome;
}