package inclui_dev_api.application.repository;

import inclui_dev_api.data.model.persist.usabilidade.InatividadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InatividadeRepository extends JpaRepository<InatividadeModel, UUID> {
    Optional<InatividadeModel> findByUsuario(UUID usuario);
}