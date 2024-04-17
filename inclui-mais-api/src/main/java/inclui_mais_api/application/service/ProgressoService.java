package inclui_mais_api.application.service;

import inclui_mais_api.application.repository.ProgressoRepository;
import inclui_mais_api.component.exception.ExceptionGeneric;
import inclui_mais_api.component.exception.NotFoundException;
import inclui_mais_api.data.dto.post.ProgressoPostDto;
import inclui_mais_api.data.mapper.ProgressoMapper;
import inclui_mais_api.data.model.persist.usabilidade.ProgressoModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProgressoService {
    private final ProgressoRepository ProgressoRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public ProgressoModel save(@Valid ProgressoPostDto progresso) {
        return ProgressoRepository.save(ProgressoMapper.toMapper(progresso));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID progresso) {
        try {
            ProgressoRepository.deleteById(progresso);
        } catch (Exception ignored) { }
    }

    /*
    public ProgressoModel update(@Valid ProgressoPostDto Progresso) {
        return ProgressoRepository.save(
                ProgressoMapper.toMapper(Progresso, findById(Progresso.getId())));
    }
    */

    public ProgressoModel findById(UUID progresso) {
        return ProgressoRepository.findById(progresso).orElseThrow(
                () -> new NotFoundException("Progresso")
        );
    }
}
