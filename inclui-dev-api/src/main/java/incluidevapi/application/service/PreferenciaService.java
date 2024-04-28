package incluidevapi.application.service;

import incluidevapi.application.repository.PreferenciaRepository;
import incluidevapi.component.exception.ExceptionGeneric;
import incluidevapi.component.exception.NotFoundException;
import incluidevapi.data.dto.post.PreferenciaPostDto;
import incluidevapi.data.dto.put.PreferenciaPutDto;
import incluidevapi.data.mapper.PreferenciaMapper;
import incluidevapi.data.model.persist.perfil.PreferenciaModel;
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
