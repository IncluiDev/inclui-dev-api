package inclui_dev_api.data.dto.put;

import inclui_dev_api.component.validation.constraint.CursoExistsById;
import inclui_dev_api.component.validation.constraint.UsuarioExistsById;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class CursoPutDto {
    @NotNull @NotEmpty @CursoExistsById
    private UUID id;

    @NotNull @NotEmpty
    private String nome, descricao, area;

    @NotNull @Positive
    private int horasDuracao;

    private List<String> tags;

    @NotNull @NotEmpty @UsuarioExistsById
    private UUID professor;
}