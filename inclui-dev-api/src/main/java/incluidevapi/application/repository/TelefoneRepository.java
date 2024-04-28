package incluidevapi.application.repository;

import incluidevapi.data.model.persist.perfil.TelefoneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TelefoneRepository extends JpaRepository<TelefoneModel, UUID> {
    Optional<List<TelefoneModel>> findAllByUsuario(UUID usuario);
}