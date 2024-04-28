package inclui_dev_api.application.service;

import inclui_dev_api.application.repository.UsuarioRepository;
import inclui_dev_api.component.exception.ExceptionGeneric;
import inclui_dev_api.component.exception.NotFoundException;
import inclui_dev_api.data.dto.post.UsuarioPostDto;
import inclui_dev_api.data.dto.put.UsuarioPutDto;
import inclui_dev_api.data.mapper.UsuarioMapper;
import inclui_dev_api.data.model.persist.perfil.UsuarioModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public UsuarioModel save(@Valid UsuarioPostDto usuario) {
        return usuarioRepository.save(UsuarioMapper.toMapper(usuario));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID usuario) {
        try {
            usuarioRepository.deleteById(usuario);
        } catch (Exception ignored) { }
    }

    public UsuarioModel update(@Valid UsuarioPutDto usuario) {
        return usuarioRepository.save(
                UsuarioMapper.toMapper(findById(usuario.getId()), usuario)
        );
    }

    public UsuarioModel findById(UUID usuario) {
        return usuarioRepository.findById(usuario).orElseThrow(
                () -> new NotFoundException("Usuario")
        );
    }
}
