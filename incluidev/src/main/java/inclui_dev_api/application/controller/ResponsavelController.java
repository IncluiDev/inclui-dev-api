package inclui_dev_api.application.controller;

import inclui_dev_api.application.service.ResponsavelService;
import inclui_dev_api.data.dto.post.ResponsavelPostDto;
import inclui_dev_api.data.dto.put.ResponsavelPutDto;
import inclui_dev_api.data.model.persist.perfil.ResponsavelModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/responsavel")
@RequiredArgsConstructor
public class ResponsavelController {
    private final ResponsavelService responsavelService;

    @PostMapping("")
    public ResponseEntity<ResponsavelModel> save(@RequestBody ResponsavelPostDto responsavel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(responsavelService.save(responsavel));
    }

    @PutMapping("")
    public ResponseEntity<ResponsavelModel> update(@RequestBody ResponsavelPutDto responsavel) {
        return ResponseEntity.status(HttpStatus.OK).body(responsavelService.update(responsavel));
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestParam UUID id) {
        responsavelService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("")
    public ResponseEntity<ResponsavelModel> findById(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(responsavelService.findById(id));
    }

    @GetMapping("/usuario")
    public ResponseEntity<ResponsavelModel> findByUsuario(@RequestParam UUID usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(responsavelService.findByUsuario(usuario));
    }
}
