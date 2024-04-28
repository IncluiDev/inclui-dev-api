package inclui_dev_api.application.service;

import inclui_dev_api.application.repository.TelefoneRepository;
import inclui_dev_api.component.exception.ExceptionGeneric;
import inclui_dev_api.component.exception.NotFoundException;
import inclui_dev_api.data.dto.post.TelefonePostDto;
import inclui_dev_api.data.dto.put.TelefonePutDto;
import inclui_dev_api.data.mapper.TelefoneMapper;
import inclui_dev_api.data.model.persist.perfil.TelefoneModel;
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
