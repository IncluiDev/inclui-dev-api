package incluidevapi.application.repository;

import incluidevapi.data.model.persist.educacional.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, UUID> {

}