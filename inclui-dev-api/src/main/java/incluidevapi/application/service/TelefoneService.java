package incluidevapi.application.service;

import incluidevapi.application.repository.TelefoneRepository;
import incluidevapi.component.exception.ExceptionGeneric;
import incluidevapi.component.exception.NotFoundException;
import incluidevapi.data.dto.post.TelefonePostDto;
import incluidevapi.data.dto.put.TelefonePutDto;
import incluidevapi.data.mapper.TelefoneMapper;
import incluidevapi.data.model.persist.perfil.TelefoneModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TelefoneService {
    private final TelefoneRepository telefoneRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public TelefoneModel save(@Valid TelefonePostDto telefone) {
        return telefoneRepository.save(TelefoneMapper.toMapper(telefone));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID telefone) {
        try {
            telefoneRepository.deleteById(telefone);
        } catch (Exception ignored) { }
    }

    public TelefoneModel update(@Valid TelefonePutDto telefone) {
        return telefoneRepository.save(
                TelefoneMapper.toMapper(findById(telefone.getId()), telefone)
        );
    }

    public TelefoneModel findById(UUID telefone) {
        return telefoneRepository.findById(telefone).orElseThrow(
                () -> new NotFoundException("TELEFONE")
        );
    }

    public List<TelefoneModel> listAllByUsuario(UUID usuario) {
        return telefoneRepository.findAllByUsuario(usuario).orElseThrow(
                () -> new NotFoundException("TELEFONE")
        );
    }
}
