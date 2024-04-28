package incluidevapi.application.service;

import incluidevapi.application.repository.InatividadeRepository;
import incluidevapi.component.exception.ExceptionGeneric;
import incluidevapi.component.exception.NotFoundException;
import incluidevapi.data.dto.post.InatividadePostDto;
import incluidevapi.data.dto.put.InatividadePutDto;
import incluidevapi.data.mapper.InatividadeMapper;
import incluidevapi.data.model.persist.usabilidade.InatividadeModel;
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
