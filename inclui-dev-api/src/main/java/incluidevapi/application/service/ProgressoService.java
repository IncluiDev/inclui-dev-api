package incluidevapi.application.service;

import incluidevapi.application.repository.ProgressoRepository;
import incluidevapi.component.exception.ExceptionGeneric;
import incluidevapi.component.exception.NotFoundException;
import incluidevapi.data.dto.post.ProgressoPostDto;
import incluidevapi.data.dto.put.ProgressoPutDto;
import incluidevapi.data.mapper.ProgressoMapper;
import incluidevapi.data.model.persist.usabilidade.ProgressoModel;
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
