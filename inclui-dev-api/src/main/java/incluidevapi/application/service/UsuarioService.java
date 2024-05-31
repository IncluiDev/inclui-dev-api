package incluidevapi.application.service;

import incluidevapi.application.repository.UsuarioRepository;
import incluidevapi.component.exception.ExceptionGeneric;
import incluidevapi.component.exception.NotFoundException;
import incluidevapi.data.dto.post.UsuarioPostDto;
import incluidevapi.data.dto.put.UsuarioPutDto;
import incluidevapi.data.mapper.UsuarioMapper;
import incluidevapi.data.model.persist.perfil.UsuarioModel;
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