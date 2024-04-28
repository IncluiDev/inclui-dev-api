package incluidevapi.application.service;

import incluidevapi.application.repository.EnderecoRepository;
import incluidevapi.component.exception.ExceptionGeneric;
import incluidevapi.component.exception.NotFoundException;
import incluidevapi.data.dto.post.EnderecoPostDto;
import incluidevapi.data.dto.put.EnderecoPutDto;
import incluidevapi.data.mapper.EnderecoMapper;
import incluidevapi.data.model.persist.perfil.EnderecoModel;
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
