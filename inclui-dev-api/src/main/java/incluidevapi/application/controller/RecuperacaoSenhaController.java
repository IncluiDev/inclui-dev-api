package incluidevapi.application.controller;

import incluidevapi.application.service.CursoService;
import incluidevapi.data.dto.post.CursoPostDto;
import incluidevapi.data.dto.put.CursoPutDto;
import incluidevapi.data.model.persist.educacional.CursoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {
    private final CursoService cursoService;

    @PostMapping("")
    public ResponseEntity<CursoModel> save(@RequestBody CursoPostDto curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(curso));
    }

    @PutMapping("")
    public ResponseEntity<CursoModel> update(@RequestBody CursoPutDto curso) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.update(curso));
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestParam UUID id) {
        cursoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("")
    public ResponseEntity<CursoModel> findById(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.findById(id));
    }
}
