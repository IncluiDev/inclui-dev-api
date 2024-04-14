package inclui_mais_api.data.model.persist.perfil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "endereco")
public class EnderecoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String cep, logradouro, complemento, pais, cidade, estado;
    private int numero;

    @OneToOne(mappedBy = "endereco")
    private UsuarioModel usuario;
}