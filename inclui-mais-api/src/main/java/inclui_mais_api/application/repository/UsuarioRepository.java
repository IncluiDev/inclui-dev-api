package inclui_mais_api.application.repository;

import inclui_mais_api.data.model.persist.perfil.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {

}