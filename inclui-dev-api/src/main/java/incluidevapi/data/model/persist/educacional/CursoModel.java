package incluidevapi.data.model.persist.educacional;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Entity
@Table(name = "curso")
public class CursoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome, area, referenciaImagem;

    @Lob
    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private int horasDuracao;

    @Column(nullable = false)
    private List<String> tags;

    // lista de videos/aulas

    @Column(nullable = false)
    private UUID professor;
}