package incluidevapi.data.model.persist.perfil;

import incluidevapi.data.model.type.PerfilTipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome, email, senha, referenciaFoto;
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private PerfilTipo perfil;
}