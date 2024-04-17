package inclui_mais_api.application.service;

import inclui_mais_api.application.repository.UsuarioRepository;
import inclui_mais_api.component.exception.ExceptionGeneric;
import inclui_mais_api.component.exception.NotFoundException;
import inclui_mais_api.data.dto.post.UsuarioPostDto;
import inclui_mais_api.data.mapper.UsuarioMapper;
import inclui_mais_api.data.model.persist.perfil.UsuarioModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository UsuarioRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public UsuarioModel save(@Valid UsuarioPostDto usuario) {
        return UsuarioRepository.save(UsuarioMapper.toMapper(usuario));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID usuario) {
        try {
            UsuarioRepository.deleteById(usuario);
        } catch (Exception ignored) { }
    }

    /*
    public UsuarioModel update(@Valid UsuarioPostDto Usuario) {
        return UsuarioRepository.save(
                UsuarioMapper.toMapper(Usuario, findById(Usuario.getId())));
    }
    */

    public UsuarioModel findById(UUID usuario) {
        return UsuarioRepository.findById(usuario).orElseThrow(
                () -> new NotFoundException("Usuario")
        );
    }
}
