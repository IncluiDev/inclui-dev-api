package inclui_dev_api.application.service;

import inclui_dev_api.application.repository.InatividadeRepository;
import inclui_dev_api.component.exception.ExceptionGeneric;
import inclui_dev_api.component.exception.NotFoundException;
import inclui_dev_api.data.dto.post.InatividadePostDto;
import inclui_dev_api.data.dto.put.InatividadePutDto;
import inclui_dev_api.data.mapper.InatividadeMapper;
import inclui_dev_api.data.model.persist.usabilidade.InatividadeModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InatividadeService {
    private final InatividadeRepository inatividadeRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public InatividadeModel save(@Valid InatividadePostDto inatividade) {
        return inatividadeRepository.save(InatividadeMapper.toMapper(inatividade));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID inatividade) {
        try {
            inatividadeRepository.deleteById(inatividade);
        } catch (Exception ignored) { }
    }

    public InatividadeModel update(@Valid InatividadePutDto inatividade) {
        return inatividadeRepository.save(
                InatividadeMapper.toMapper(findById(inatividade.getId()), inatividade)
        );
    }

    public InatividadeModel findById(UUID inatividade) {
        return inatividadeRepository.findById(inatividade).orElseThrow(
                () -> new NotFoundException("Inatividade")
        );
    }

    public InatividadeModel findByUsuario(UUID usuario) {
        return inatividadeRepository.findByUsuario(usuario).orElseThrow(
                () -> new NotFoundException("Inatividade")
        );
    }
}
