package inclui_mais_api.application.repository;

import inclui_mais_api.data.model.persist.educacional.JogoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JogoRepository extends JpaRepository<JogoModel, UUID> {

}