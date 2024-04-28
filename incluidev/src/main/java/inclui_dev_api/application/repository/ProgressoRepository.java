package inclui_dev_api.application.repository;

import inclui_dev_api.data.model.persist.usabilidade.ProgressoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProgressoRepository extends JpaRepository<ProgressoModel, UUID> {

}