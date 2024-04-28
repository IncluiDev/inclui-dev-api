package incluidevapi.application.repository;

import incluidevapi.data.model.persist.educacional.JogoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JogoRepository extends JpaRepository<JogoModel, UUID> {

}