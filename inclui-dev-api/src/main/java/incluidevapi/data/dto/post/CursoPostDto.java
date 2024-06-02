package incluidevapi.data.dto.post;

import incluidevapi.component.validation.constraint.UsuarioExistsById;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoPostDto {
    @NotNull @NotEmpty
    private String nome, descricao, area, referenciaImagem;

    @NotNull @Positive
    private int horasDuracao;

    private List<String> tags;

    @NotNull @NotEmpty @UsuarioExistsById
    private UUID professor;
}
