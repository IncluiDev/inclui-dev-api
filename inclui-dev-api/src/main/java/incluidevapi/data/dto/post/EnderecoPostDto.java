package incluidevapi.data.dto.post;

import incluidevapi.component.validation.constraint.UsuarioExistsById;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EnderecoPostDto {
    @NotNull @NotEmpty
    private String logradouro, cep, cidade, estado, pais;

    @NotNull @Positive
    private int numero;

    private String complemento;

    @NotNull @NotEmpty @UsuarioExistsById
    private UUID usuario;
}
