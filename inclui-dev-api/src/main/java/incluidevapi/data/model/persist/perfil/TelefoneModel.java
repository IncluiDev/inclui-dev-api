package incluidevapi.data.model.persist.perfil;

import incluidevapi.data.model.type.TelefoneTipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
