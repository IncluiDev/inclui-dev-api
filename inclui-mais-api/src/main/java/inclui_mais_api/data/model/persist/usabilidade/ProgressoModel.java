package inclui_mais_api.data.model.persist.usabilidade;

import inclui_mais_api.data.model.type.EducativoTipo;
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
@Table(name = "progresso")
public class ProgressoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private int progresso;

    @Enumerated(EnumType.STRING)
    private EducativoTipo modalidade;

    private UUID educativo, usuario;
}