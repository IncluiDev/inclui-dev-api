package inclui_mais_api.application.controller;

import inclui_mais_api.application.service.PreferenciaService;
import inclui_mais_api.data.dto.post.PreferenciaPostDto;
import inclui_mais_api.data.model.persist.perfil.PreferenciaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/preferencia")
@RequiredArgsConstructor
public class PreferenciaController {
    private final PreferenciaService preferenciaService;

    @PostMapping("")
    public ResponseEntity<PreferenciaModel> save(@RequestBody PreferenciaPostDto preferencia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(preferenciaService.save(preferencia));
    }

    /*
    @PutMapping("")
    public ResponseEntity<PreferenciaModel> update(@RequestBody PreferenciaPutDto preferencia) {
        return ResponseEntity.status(HttpStatus.OK).body(preferenciaService.update(preferencia));
    }
    */

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestParam UUID id) {
        preferenciaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("")
    public ResponseEntity<PreferenciaModel> findById(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(preferenciaService.findById(id));
    }

    @GetMapping("/usuario")
    public ResponseEntity<PreferenciaModel> findByUsuario(@RequestParam UUID usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(preferenciaService.findByUsuario(usuario));
    }
}
