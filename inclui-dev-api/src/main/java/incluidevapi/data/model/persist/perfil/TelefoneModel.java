package incluidevapi.data.model.persist.perfil;

import incluidevapi.data.model.type.TelefoneTipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Entity
@Table(name = "telefone")
public class TelefoneModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String regiao, ddd, numero;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TelefoneTipo tipo;

    @Column(nullable = false)
    private UUID usuario;
}
