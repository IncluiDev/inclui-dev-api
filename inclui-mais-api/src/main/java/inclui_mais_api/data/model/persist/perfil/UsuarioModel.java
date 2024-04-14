package inclui_mais_api.data.model.persist.perfil;

import inclui_mais_api.data.model.type.PerfilTipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome, email, senha;
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private PerfilTipo perfil;
}