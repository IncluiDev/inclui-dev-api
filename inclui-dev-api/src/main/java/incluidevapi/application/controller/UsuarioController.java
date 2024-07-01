package incluidevapi.application.controller;

import incluidevapi.application.service.UsuarioService;
import incluidevapi.data.dto.post.UsuarioPostDto;
import incluidevapi.data.dto.put.UsuarioPutDto;
import incluidevapi.data.model.persist.perfil.UsuarioModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping("")
    public ResponseEntity<UsuarioModel> save(@RequestBody UsuarioPostDto usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @PutMapping("")
    public ResponseEntity<UsuarioModel> update(@RequestBody UsuarioPutDto usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.update(usuario));
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestParam UUID id) {
        usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("")
    public ResponseEntity<UsuarioModel> findById(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
    }

    @GetMapping("/record")
    public ResponseEntity<UsuarioModel> findByEmail(@RequestParam String email) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findByEmail(email));
    }
}
