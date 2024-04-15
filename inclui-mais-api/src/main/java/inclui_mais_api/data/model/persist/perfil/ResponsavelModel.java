package inclui_mais_api.data.model.persist.perfil;

import lombok.*;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "responsavel")
public class ResponsavelModel extends UsuarioModel {
    private UUID usuario;
}