package inclui_dev_api.application.service;

import inclui_dev_api.application.repository.PreferenciaRepository;
import inclui_dev_api.component.exception.ExceptionGeneric;
import inclui_dev_api.component.exception.NotFoundException;
import inclui_dev_api.data.dto.post.PreferenciaPostDto;
import inclui_dev_api.data.dto.put.PreferenciaPutDto;
import inclui_dev_api.data.mapper.PreferenciaMapper;
import inclui_dev_api.data.model.persist.perfil.PreferenciaModel;
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

    public PreferenciaModel update(@Valid PreferenciaPutDto preferencia) {
        return preferenciaRepository.save(
                PreferenciaMapper.toMapper(findById(preferencia.getId()), preferencia)
        );
    }

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
