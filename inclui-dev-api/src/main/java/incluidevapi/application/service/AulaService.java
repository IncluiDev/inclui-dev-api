package incluidevapi.application.service;

import incluidevapi.application.repository.AulaRepository;
import incluidevapi.component.exception.ExceptionGeneric;
import incluidevapi.component.exception.NotFoundException;
import incluidevapi.data.dto.post.AulaPostDto;
import incluidevapi.data.dto.put.AulaPutDto;
import incluidevapi.data.mapper.AulaMapper;
import incluidevapi.data.model.persist.educacional.AulaModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AulaService {
    private final AulaRepository aulaRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public AulaModel save(@Valid AulaPostDto aula) {
        return aulaRepository.save(AulaMapper.toMapper(aula));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID aula) {
        try {
            aulaRepository.deleteById(aula);
        } catch (Exception ignored) { }
    }

    public AulaModel update(@Valid AulaPutDto aula) {
        return aulaRepository.save(
                AulaMapper.toMapper(findById(aula.getId()), aula)
        );
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public AulaModel findById(UUID aula) {
        return aulaRepository.findById(aula).orElseThrow(
                () -> new NotFoundException("Aula")
        );
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public List<AulaModel> findAllByCurso(UUID curso) {
        return aulaRepository.findAllByCurso(curso).orElseThrow(
                () -> new NotFoundException("Aula")
        );
    }
}
