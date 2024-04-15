package inclui_mais_api.data.dto.post;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class CursoPostDto {
    @NotNull @NotEmpty
    private String nome, descricao, area;

    @NotNull @Positive
    private int horasDuracao;

    private List<String> tags;

    @NotNull @NotEmpty
    private UUID professor;
}
