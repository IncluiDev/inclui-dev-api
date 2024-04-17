package inclui_mais_api.application.service;

import inclui_mais_api.application.repository.ResponsavelRepository;
import inclui_mais_api.component.exception.ExceptionGeneric;
import inclui_mais_api.component.exception.NotFoundException;
import inclui_mais_api.data.dto.post.ResponsavelPostDto;
import inclui_mais_api.data.mapper.ResponsavelMapper;
import inclui_mais_api.data.model.persist.perfil.ResponsavelModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResponsavelService {
    private final ResponsavelRepository ResponsavelRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public ResponsavelModel save(@Valid ResponsavelPostDto responsavel) {
        return ResponsavelRepository.save(ResponsavelMapper.toMapper(responsavel));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID responsavel) {
        try {
            ResponsavelRepository.deleteById(responsavel);
        } catch (Exception ignored) { }
    }

    /*
    public ResponsavelModel update(@Valid ResponsavelPostDto Responsavel) {
        return ResponsavelRepository.save(
                ResponsavelMapper.toMapper(Responsavel, findById(Responsavel.getId())));
    }
    */

    public ResponsavelModel findById(UUID responsavel) {
        return ResponsavelRepository.findById(responsavel).orElseThrow(
                () -> new NotFoundException("Responsavel")
        );
    }

    public ResponsavelModel findByUsuario(UUID usuario) {
        return ResponsavelRepository.findByUsuario(usuario).orElseThrow(
                () -> new NotFoundException("Responsavel")
        );
    }
}
