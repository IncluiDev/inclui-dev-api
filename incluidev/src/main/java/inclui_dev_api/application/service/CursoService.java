package inclui_dev_api.application.service;

import inclui_dev_api.application.repository.CursoRepository;
import inclui_dev_api.component.exception.ExceptionGeneric;
import inclui_dev_api.component.exception.NotFoundException;
import inclui_dev_api.data.dto.post.CursoPostDto;
import inclui_dev_api.data.dto.put.CursoPutDto;
import inclui_dev_api.data.mapper.CursoMapper;
import inclui_dev_api.data.model.persist.educacional.CursoModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
