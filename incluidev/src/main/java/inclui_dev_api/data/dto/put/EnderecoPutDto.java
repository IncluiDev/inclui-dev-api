package inclui_dev_api.data.dto.put;

import inclui_dev_api.component.validation.constraint.EnderecoExistsById;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EnderecoPutDto {
    @NotNull @NotEmpty @EnderecoExistsById
    private UUID id;

    @NotNull @NotEmpty
    private String logradouro, cep, cidade, estado, pais;

    @NotNull @Positive
    private int numero;

    private String complemento;
}
