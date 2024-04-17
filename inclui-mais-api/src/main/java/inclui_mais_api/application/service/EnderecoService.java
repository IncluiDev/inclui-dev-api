package inclui_mais_api.application.service;

import inclui_mais_api.application.repository.EnderecoRepository;
import inclui_mais_api.component.exception.ExceptionGeneric;
import inclui_mais_api.component.exception.NotFoundException;
import inclui_mais_api.data.dto.post.EnderecoPostDto;
import inclui_mais_api.data.mapper.EnderecoMapper;
import inclui_mais_api.data.model.persist.perfil.EnderecoModel;
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

    /*
    public EnderecoModel update(@Valid EnderecoPostDto Endereco) {
        return EnderecoRepository.save(
                EnderecoMapper.toMapper(Endereco, findById(Endereco.getId())));
    }
    */

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
