package inclui_dev_api.data.model.persist.perfil;

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
@Table(name = "preferencia")
public class PreferenciaModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // mobilidades
    private boolean visual, motora, auditiva, cognitiva, atencao, dislexia, autismo, sindromeDown;

    private UUID usuario;
}
