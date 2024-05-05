package incluidevapi.application.controller;

import incluidevapi.application.service.RecuperacaoSenhaService;
import incluidevapi.data.dto.post.RecuperacaoSenhaPostDto;
import incluidevapi.data.dto.put.RecuperacaoSenhaPutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recuperacao")
@RequiredArgsConstructor
public class RecuperacaoSenhaController {
    private final RecuperacaoSenhaService recuperacaoSenhaService;

    @PostMapping("")
    public ResponseEntity<Void> getRecuperacaoForEmail(@RequestBody RecuperacaoSenhaPostDto recuperacao) {
        recuperacaoSenhaService.getRecuperacaoForEmail(recuperacao);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("")
    public ResponseEntity<Void> changeCredentials(@RequestBody RecuperacaoSenhaPutDto recuperacao) {
        recuperacaoSenhaService.changeUsuario(recuperacao);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
