package inclui_mais_api.application.repository;

import inclui_mais_api.data.model.persist.perfil.ResponsavelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ResponsavelRepository extends JpaRepository<ResponsavelModel, UUID> {
    Optional<ResponsavelModel> findByUsuario(UUID usuario);
}