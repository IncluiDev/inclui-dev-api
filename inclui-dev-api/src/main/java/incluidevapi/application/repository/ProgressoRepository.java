package incluidevapi.application.repository;

import incluidevapi.data.model.persist.usabilidade.ProgressoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProgressoRepository extends JpaRepository<ProgressoModel, UUID> {

}