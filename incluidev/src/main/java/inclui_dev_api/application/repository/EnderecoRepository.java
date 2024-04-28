package inclui_dev_api.application.repository;

import inclui_dev_api.data.model.persist.perfil.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, UUID> {
    Optional<EnderecoModel> findByUsuario(UUID usuario);
}