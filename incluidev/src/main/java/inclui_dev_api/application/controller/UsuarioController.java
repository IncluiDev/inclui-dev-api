package inclui_dev_api.application.controller;

import inclui_dev_api.application.service.UsuarioService;
import inclui_dev_api.data.dto.post.UsuarioPostDto;
import inclui_dev_api.data.dto.put.UsuarioPutDto;
import inclui_dev_api.data.model.persist.perfil.UsuarioModel;
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
}