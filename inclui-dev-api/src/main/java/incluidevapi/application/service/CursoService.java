package incluidevapi.application.service;

import incluidevapi.application.repository.CursoRepository;
import incluidevapi.component.exception.ExceptionGeneric;
import incluidevapi.component.exception.NotFoundException;
import incluidevapi.data.dto.post.CursoPostDto;
import incluidevapi.data.dto.put.CursoPutDto;
import incluidevapi.data.mapper.CursoMapper;
import incluidevapi.data.model.persist.educacional.CursoModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CursoService {
    private final CursoRepository cursoRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public CursoModel save(@Valid CursoPostDto curso) {
        return cursoRepository.save(CursoMapper.toMapper(curso));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID curso) {
        try {
            cursoRepository.deleteById(curso);
        } catch (Exception ignored) { }
    }

    public CursoModel update(@Valid CursoPutDto curso) {
        return cursoRepository.save(
                CursoMapper.toMapper(findById(curso.getId()), curso)
        );
    }

    public CursoModel findById(UUID curso) {
        return cursoRepository.findById(curso).orElseThrow(
                () -> new NotFoundException("Curso")
        );
    }

    public List<CursoModel> findAll() {
        return cursoRepository.findAll();
    }
}
