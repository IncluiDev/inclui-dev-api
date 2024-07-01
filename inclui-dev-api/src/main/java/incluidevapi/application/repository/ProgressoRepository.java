package incluidevapi.application.repository;

import incluidevapi.data.model.persist.usabilidade.ProgressoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProgressoRepository extends JpaRepository<ProgressoModel, UUID> {
    Optional<ProgressoModel> findByUsuarioAndEducativo(UUID usuario, UUID educativo);
    Optional<List<ProgressoModel>> findAllByUsuario(UUID usuario);

}