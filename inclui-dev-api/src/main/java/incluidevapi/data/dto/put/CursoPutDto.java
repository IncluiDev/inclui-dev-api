package incluidevapi.data.dto.put;

import incluidevapi.component.validation.constraint.CursoExistsById;
import incluidevapi.component.validation.constraint.UsuarioExistsById;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoPutDto {
    @CursoExistsById
    private UUID id;

    private String nome, descricao, area, referenciaImagem;
    private int horasDuracao;
    private List<String> tags;

    private UUID professor;
}
