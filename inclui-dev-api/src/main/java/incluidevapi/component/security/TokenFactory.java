package incluidevapi.component.security;

import incluidevapi.data.dto.post.AuthPostDto;
import incluidevapi.data.model.dynamic.TokenModel;
import incluidevapi.data.model.persist.perfil.UsuarioModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenFactory {
    private final TokenSecurity tokenService;
    private final AuthenticationManager authenticationManager;

    public TokenModel createToken(AuthPostDto usuario) {
        return new TokenModel(tokenService.generateToken(
                (UsuarioModel)
                        authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha())
                        ).getPrincipal()
        ));
    }
}