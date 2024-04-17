package inclui_mais_api.application.service;

import inclui_mais_api.application.repository.CursoRepository;
import inclui_mais_api.component.exception.ExceptionGeneric;
import inclui_mais_api.component.exception.NotFoundException;
import inclui_mais_api.data.dto.post.CursoPostDto;
import inclui_mais_api.data.mapper.CursoMapper;
import inclui_mais_api.data.model.persist.educacional.CursoModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CursoService {
    private final CursoRepository CursoRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public CursoModel save(@Valid CursoPostDto curso) {
        return CursoRepository.save(CursoMapper.toMapper(curso));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID curso) {
        try {
            CursoRepository.deleteById(curso);
        } catch (Exception ignored) { }
    }

    /*
    public CursoModel update(@Valid CursoPostDto Curso) {
        return CursoRepository.save(
                CursoMapper.toMapper(Curso, findById(Curso.getId())));
    }
    */

    public CursoModel findById(UUID curso) {
        return CursoRepository.findById(curso).orElseThrow(
                () -> new NotFoundException("Curso")
        );
    }
}
