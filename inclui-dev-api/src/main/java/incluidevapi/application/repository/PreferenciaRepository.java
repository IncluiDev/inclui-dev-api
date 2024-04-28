package incluidevapi.application.repository;

import incluidevapi.data.model.persist.perfil.PreferenciaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PreferenciaRepository extends JpaRepository<PreferenciaModel, UUID> {
    Optional<PreferenciaModel> findByUsuario(UUID preferencia);
}