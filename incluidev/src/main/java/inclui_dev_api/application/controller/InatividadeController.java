package inclui_dev_api.application.controller;

import inclui_dev_api.application.service.InatividadeService;
import inclui_dev_api.data.dto.post.InatividadePostDto;
import inclui_dev_api.data.dto.put.InatividadePutDto;
import inclui_dev_api.data.model.persist.usabilidade.InatividadeModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/inatividade")
@RequiredArgsConstructor
public class InatividadeController {
    private final InatividadeService inatividadeService;

    @PostMapping("")
    public ResponseEntity<InatividadeModel> save(@RequestBody InatividadePostDto inatividade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inatividadeService.save(inatividade));
    }

    @PutMapping("")
    public ResponseEntity<InatividadeModel> update(@RequestBody InatividadePutDto inatividade) {
        return ResponseEntity.status(HttpStatus.OK).body(inatividadeService.update(inatividade));
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestParam UUID id) {
        inatividadeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("")
    public ResponseEntity<InatividadeModel> findById(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(inatividadeService.findById(id));
    }

    @GetMapping("/usuario")
    public ResponseEntity<InatividadeModel> findByUsuario(@RequestParam UUID usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(inatividadeService.findByUsuario(usuario));
    }
}
