package inclui_mais_api.data.model.persist.educacional;

import inclui_mais_api.data.model.persist.perfil.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "curso")
public class CursoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome, descricao, area;
    private int horasDuracao;
    private List<String> tags;

    // lista de videos/aulas

    private UsuarioModel professor;
}