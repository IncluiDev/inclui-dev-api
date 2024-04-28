package inclui_dev_api.application.service;

import inclui_dev_api.application.repository.ResponsavelRepository;
import inclui_dev_api.component.exception.ExceptionGeneric;
import inclui_dev_api.component.exception.NotFoundException;
import inclui_dev_api.data.dto.post.ResponsavelPostDto;
import inclui_dev_api.data.dto.put.ResponsavelPutDto;
import inclui_dev_api.data.mapper.ResponsavelMapper;
import inclui_dev_api.data.model.persist.perfil.ResponsavelModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResponsavelService {
    private final ResponsavelRepository responsavelRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public ResponsavelModel save(@Valid ResponsavelPostDto responsavel) {
        return responsavelRepository.save(ResponsavelMapper.toMapper(responsavel));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID responsavel) {
        try {
            responsavelRepository.deleteById(responsavel);
        } catch (Exception ignored) { }
    }

    public ResponsavelModel update(@Valid ResponsavelPutDto responsavel) {
        return responsavelRepository.save(
                ResponsavelMapper.toMapper(findById(responsavel.getId()), responsavel)
        );
    }

    public ResponsavelModel findById(UUID responsavel) {
        return responsavelRepository.findById(responsavel).orElseThrow(
                () -> new NotFoundException("Responsavel")
        );
    }

    public ResponsavelModel findByUsuario(UUID usuario) {
        return responsavelRepository.findByUsuario(usuario).orElseThrow(
                () -> new NotFoundException("Responsavel")
        );
    }
}
