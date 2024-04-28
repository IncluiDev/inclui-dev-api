package inclui_dev_api.application.service;

import inclui_dev_api.application.repository.ProgressoRepository;
import inclui_dev_api.component.exception.ExceptionGeneric;
import inclui_dev_api.component.exception.NotFoundException;
import inclui_dev_api.data.dto.post.ProgressoPostDto;
import inclui_dev_api.data.dto.put.ProgressoPutDto;
import inclui_dev_api.data.mapper.ProgressoMapper;
import inclui_dev_api.data.model.persist.usabilidade.ProgressoModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProgressoService {
    private final ProgressoRepository progressoRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public ProgressoModel save(@Valid ProgressoPostDto progresso) {
        return progressoRepository.save(ProgressoMapper.toMapper(progresso));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID progresso) {
        try {
            progressoRepository.deleteById(progresso);
        } catch (Exception ignored) { }
    }

    public ProgressoModel update(@Valid ProgressoPutDto progresso) {
        return progressoRepository.save(
                ProgressoMapper.toMapper(findById(progresso.getId()), progresso)
        );
    }

    public ProgressoModel findById(UUID progresso) {
        return progressoRepository.findById(progresso).orElseThrow(
                () -> new NotFoundException("Progresso")
        );
    }
}
