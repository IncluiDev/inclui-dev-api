package incluidevapi.data.dto.post;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPostDto {
    @NotNull @NotEmpty
    private String nome, senha;

    @NotNull @NotEmpty @Email
    private String email;

    @NotNull
    private LocalDate dataNascimento;
}