package inclui_mais_api.application.service;

import inclui_mais_api.application.repository.PreferenciaRepository;
import inclui_mais_api.component.exception.ExceptionGeneric;
import inclui_mais_api.component.exception.NotFoundException;
import inclui_mais_api.data.dto.post.PreferenciaPostDto;
import inclui_mais_api.data.mapper.PreferenciaMapper;
import inclui_mais_api.data.model.persist.perfil.PreferenciaModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PreferenciaService {
    private final PreferenciaRepository preferenciaRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public PreferenciaModel save(@Valid PreferenciaPostDto preferencia) {
        return preferenciaRepository.save(PreferenciaMapper.toMapper(preferencia));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID preferencia) {
        try {
            preferenciaRepository.deleteById(preferencia);
        } catch (Exception ignored) { }
    }

    /*
    public PreferenciaModel update(@Valid PreferenciaPostDto Preferencia) {
        return PreferenciaRepository.save(
                PreferenciaMapper.toMapper(Preferencia, findById(Preferencia.getId())));
    }
    */

    public PreferenciaModel findById(UUID preferencia) {
        return preferenciaRepository.findById(preferencia).orElseThrow(
                () -> new NotFoundException("Preferencia")
        );
    }

    public PreferenciaModel findByUsuario(UUID usuario) {
        return preferenciaRepository.findByUsuario(usuario).orElseThrow(
                () -> new NotFoundException("Preferencia")
        );
    }
}
