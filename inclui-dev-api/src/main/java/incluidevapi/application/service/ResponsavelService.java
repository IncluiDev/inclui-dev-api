package incluidevapi.application.service;

import incluidevapi.application.repository.ResponsavelRepository;
import incluidevapi.component.exception.ExceptionGeneric;
import incluidevapi.component.exception.NotFoundException;
import incluidevapi.data.dto.post.ResponsavelPostDto;
import incluidevapi.data.dto.put.ResponsavelPutDto;
import incluidevapi.data.mapper.ResponsavelMapper;
import incluidevapi.data.model.persist.perfil.ResponsavelModel;
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
