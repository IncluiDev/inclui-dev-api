package inclui_mais_api.application.service;

import inclui_mais_api.application.repository.InatividadeRepository;
import inclui_mais_api.component.exception.ExceptionGeneric;
import inclui_mais_api.component.exception.NotFoundException;
import inclui_mais_api.data.dto.post.InatividadePostDto;
import inclui_mais_api.data.mapper.InatividadeMapper;
import inclui_mais_api.data.model.persist.usabilidade.InatividadeModel;
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

    /*
    public InatividadeModel update(@Valid InatividadePostDto Inatividade) {
        return InatividadeRepository.save(
                InatividadeMapper.toMapper(Inatividade, findById(Inatividade.getId())));
    }
    */

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
