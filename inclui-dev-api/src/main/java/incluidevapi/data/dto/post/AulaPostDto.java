package incluidevapi.data.dto.post;

import incluidevapi.component.validation.constraint.CursoExistsById;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AulaPostDto {
    @NotNull @NotEmpty
    private String nome, referenciaVideo, descricaoImagem, transcricao, descricao;

    @NotNull @NotEmpty @CursoExistsById
    private UUID curso;
}
