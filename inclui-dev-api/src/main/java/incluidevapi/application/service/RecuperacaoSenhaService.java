package incluidevapi.application.service;

import incluidevapi.application.repository.RecuperacaoSenhaRepository;
import incluidevapi.application.repository.UsuarioRepository;
import incluidevapi.component.exception.ExceptionGeneric;
import incluidevapi.component.exception.NotFoundException;
import incluidevapi.component.util.GenerateCode;
import incluidevapi.component.util.WebClient;
import incluidevapi.data.dto.post.RecuperacaoSenhaPostDto;
import incluidevapi.data.dto.put.RecuperacaoSenhaPutDto;
import incluidevapi.data.model.dynamic.RecuperacaoSenhaModel;
import incluidevapi.data.model.persist.perfil.UsuarioModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RecuperacaoSenhaService {
    private final RecuperacaoSenhaRepository recuperacaoSenhaRepository;
    private final UsuarioRepository usuarioRepository;
    private final WebClient client;

    public void getRecuperacaoForEmail(@Valid RecuperacaoSenhaPostDto recuperacao) {
        try {
            client.sendRecuperacaoEmail(
                    recuperacaoSenhaRepository.existsByEmail(recuperacao.getEmail()) ?
                            findCodigo(recuperacao.getEmail()) : save(recuperacao.getEmail())
            );
        } catch (Exception ignored) { }
    }

    public void changeUsuario(@Valid RecuperacaoSenhaPutDto recuperacao) {
        usuarioRepository.save(
                setPassword(usuarioRepository.findByEmail(recuperacao.getEmail()).orElseThrow(
                        () -> new NotFoundException("RECUPERACAO")
                ), recuperacao.getSenha())
        );
    }

    private UsuarioModel setPassword(UsuarioModel usuario, String senha) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(senha));
        return usuario;
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    private RecuperacaoSenhaModel save(String email) {
        return recuperacaoSenhaRepository.save(
                new RecuperacaoSenhaModel(email, GenerateCode.getCode())
        );
    }

    private RecuperacaoSenhaModel findCodigo(String email) {
        return recuperacaoSenhaRepository.findByEmail(email).orElseThrow(
                () -> new NotFoundException("CODIGO DE RECUPERACAO")
        );
    }

    private void dropTable() {
        // recuperacaoSenhaRepository.deleteAll();
    }
}
