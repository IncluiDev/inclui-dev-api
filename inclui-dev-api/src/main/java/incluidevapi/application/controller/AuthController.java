package incluidevapi.application.controller;

import incluidevapi.component.security.TokenFactory;
import incluidevapi.component.security.TokenValidation;
import incluidevapi.data.dto.post.AuthCheckPostDto;
import incluidevapi.data.dto.post.AuthPostDto;
import incluidevapi.data.model.dynamic.TokenModel;
import incluidevapi.data.model.dynamic.TokenValidModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final TokenFactory tokenFactory;
    private final TokenValidation tokenValidation;

    @PostMapping("")
    public ResponseEntity<TokenModel> findAuth(@RequestBody AuthPostDto usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(tokenFactory.createToken(usuario));
    }

    @PostMapping("/check")
    public ResponseEntity<TokenValidModel> verifyToken(@RequestBody AuthCheckPostDto token) {
        return ResponseEntity.status(HttpStatus.OK).body(tokenValidation.isValid(token));
    }
}