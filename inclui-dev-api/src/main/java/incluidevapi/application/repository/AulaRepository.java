package incluidevapi.application.repository;

import incluidevapi.data.model.persist.educacional.AulaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AulaRepository extends JpaRepository<AulaModel, UUID> {
    Optional<List<AulaModel>> findAllByCurso(UUID curso);

    @Query(nativeQuery = true, value = "SELECT COUNT(a) FROM aula a WHERE a.curso = :curso")
    int countAulasByCurso(@Param("curso") UUID curso);
}