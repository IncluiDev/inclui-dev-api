package inclui_mais_api.data.model.persist.perfil;

import lombok.*;

import jakarta.persistence.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "responsavel")
public class ResponsavelModel extends UsuarioModel {
    private UUID usuario;
}