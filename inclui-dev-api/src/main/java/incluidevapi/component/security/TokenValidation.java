package incluidevapi.component.security;

import incluidevapi.component.util.DateGetter;
import incluidevapi.data.dto.post.AuthCheckPostDto;
import incluidevapi.data.model.dynamic.TokenValidModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenValidation {
    private final TokenSecurity tokenService;

    public TokenValidModel isValid(AuthCheckPostDto token) {
        return checkToken(token.getToken());
    }

    private TokenValidModel checkToken(String token) {
        return new TokenValidModel(DateGetter.getDate(), token, !tokenService.validateToken(token).equals(""));
    }
}