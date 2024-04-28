package inclui_dev_api.application.service;

import inclui_dev_api.application.repository.EnderecoRepository;
import inclui_dev_api.component.exception.ExceptionGeneric;
import inclui_dev_api.component.exception.NotFoundException;
import inclui_dev_api.data.dto.post.EnderecoPostDto;
import inclui_dev_api.data.dto.put.EnderecoPutDto;
import inclui_dev_api.data.mapper.EnderecoMapper;
import inclui_dev_api.data.model.persist.perfil.EnderecoModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public EnderecoModel save(@Valid EnderecoPostDto endereco) {
        return enderecoRepository.save(EnderecoMapper.toMapper(endereco));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID endereco) {
        try {
            enderecoRepository.deleteById(endereco);
        } catch (Exception ignored) { }
    }

    public EnderecoModel update(@Valid EnderecoPutDto endereco) {
        return enderecoRepository.save(
                EnderecoMapper.toMapper(findById(endereco.getId()), endereco)
        );
    }

    public EnderecoModel findById(UUID endereco) {
        return enderecoRepository.findById(endereco).orElseThrow(
                () -> new NotFoundException("Endereco")
        );
    }

    public EnderecoModel findByUsuario(UUID usuario) {
        return enderecoRepository.findByUsuario(usuario).orElseThrow(
                () -> new NotFoundException("Endereco")
        );
    }
}
