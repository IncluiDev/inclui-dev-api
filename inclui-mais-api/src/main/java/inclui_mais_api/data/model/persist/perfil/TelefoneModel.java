package inclui_mais_api.data.model.persist.perfil;

import inclui_mais_api.data.model.type.TelefoneTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "telefone")
public class TelefoneModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String regiao, ddd, numero;

    @Enumerated(EnumType.STRING)
    private TelefoneTipo tipo;

    private UUID usuario;
}
