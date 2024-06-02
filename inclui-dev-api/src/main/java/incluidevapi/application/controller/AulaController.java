package incluidevapi.application.controller;

import incluidevapi.application.service.AulaService;
import incluidevapi.data.dto.post.AulaPostDto;
import incluidevapi.data.dto.put.AulaPutDto;
import incluidevapi.data.model.persist.educacional.AulaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aula")
@RequiredArgsConstructor
public class AulaController {
    private final AulaService aulaService;

    @PostMapping("")
    public ResponseEntity<AulaModel> save(@RequestBody AulaPostDto aula) {
        return ResponseEntity.status(HttpStatus.CREATED).body(aulaService.save(aula));
    }

    @PutMapping("")
    public ResponseEntity<AulaModel> update(@RequestBody AulaPutDto aula) {
        return ResponseEntity.status(HttpStatus.OK).body(aulaService.update(aula));
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestParam UUID id) {
        aulaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("")
    public ResponseEntity<AulaModel> findById(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(aulaService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AulaModel>> findAllByCurso(@RequestParam UUID curso) {
        return ResponseEntity.status(HttpStatus.OK).body(aulaService.findAllByCurso(curso));
    }
}
