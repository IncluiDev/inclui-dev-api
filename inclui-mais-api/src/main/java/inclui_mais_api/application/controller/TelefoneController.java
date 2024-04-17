package inclui_mais_api.application.controller;

import inclui_mais_api.application.service.TelefoneService;
import inclui_mais_api.data.dto.post.TelefonePostDto;
import inclui_mais_api.data.model.persist.perfil.TelefoneModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/telefone")
@RequiredArgsConstructor
public class TelefoneController {
    private final TelefoneService telefoneService;

    @PostMapping("")
    public ResponseEntity<TelefoneModel> save(@RequestBody TelefonePostDto telefone) {
        return ResponseEntity.status(HttpStatus.CREATED).body(telefoneService.save(telefone));
    }

    /*
    @PutMapping("")
    public ResponseEntity<TelefoneModel> update(@RequestBody TelefonePutDto telefone) {
        return ResponseEntity.status(HttpStatus.OK).body(telefoneService.update(telefone));
    }
    */

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestParam UUID id) {
        telefoneService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("")
    public ResponseEntity<TelefoneModel> findById(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(telefoneService.findById(id));
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<TelefoneModel>> findAllByUsuario(@RequestParam UUID usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(telefoneService.listAllByUsuario(usuario));
    }
}
