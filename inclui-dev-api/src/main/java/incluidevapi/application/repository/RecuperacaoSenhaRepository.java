package incluidevapi.application.repository;

import incluidevapi.data.model.dynamic.RecuperacaoSenhaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecuperacaoSenhaRepository extends JpaRepository<RecuperacaoSenhaModel, UUID> {
    boolean existsByEmail(String email);
    Optional<RecuperacaoSenhaModel> findByEmail(String email);
}