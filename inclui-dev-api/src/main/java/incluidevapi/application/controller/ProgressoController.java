package incluidevapi.application.controller;

import incluidevapi.application.service.ProgressoService;
import incluidevapi.data.dto.post.ProgressoPostDto;
import incluidevapi.data.dto.put.ProgressoPutDto;
import incluidevapi.data.model.persist.usabilidade.ProgressoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/progresso")
@RequiredArgsConstructor
public class ProgressoController {
    private final ProgressoService progressoService;

    @PostMapping("")
    public ResponseEntity<ProgressoModel> save(@RequestBody ProgressoPostDto progresso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(progressoService.save(progresso));
    }

    @PutMapping("")
    public ResponseEntity<ProgressoModel> update(@RequestBody ProgressoPutDto progresso) {
        return ResponseEntity.status(HttpStatus.OK).body(progressoService.update(progresso));
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestParam UUID id) {
        progressoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("")
    public ResponseEntity<ProgressoModel> findById(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(progressoService.findById(id));
    }
}
