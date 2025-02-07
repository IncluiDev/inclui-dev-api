package incluidevapi.data.model.persist.usabilidade;

import incluidevapi.data.model.type.EducativoTipo;
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
@Table(name = "progresso")
public class ProgressoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private int progresso;

    @Transient
    private double porcentagem;

    @Enumerated(EnumType.STRING)
    private EducativoTipo modalidade;

    private UUID educativo, usuario;
}