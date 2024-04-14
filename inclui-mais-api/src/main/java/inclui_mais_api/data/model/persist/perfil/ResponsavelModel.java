package inclui_mais_api.data.model.persist.perfil;

import lombok.*;

import jakarta.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "responsavel")
public class ResponsavelModel extends UsuarioModel {
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuario;
}
