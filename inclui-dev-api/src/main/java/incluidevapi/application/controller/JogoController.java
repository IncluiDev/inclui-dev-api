package incluidevapi.application.controller;

import incluidevapi.application.service.JogoService;
import incluidevapi.data.dto.post.JogoPostDto;
import incluidevapi.data.dto.put.JogoPutDto;
import incluidevapi.data.model.persist.educacional.JogoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/jogo")
@RequiredArgsConstructor
public class JogoController {
    private final JogoService jogoService;

    @PostMapping("")
    public ResponseEntity<JogoModel> save(@RequestBody JogoPostDto jogo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jogoService.save(jogo));
    }

    @PutMapping("")
    public ResponseEntity<JogoModel> update(@RequestBody JogoPutDto jogo) {
        return ResponseEntity.status(HttpStatus.OK).body(jogoService.update(jogo));
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestParam UUID id) {
        jogoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("")
    public ResponseEntity<JogoModel> findById(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(jogoService.findById(id));
    }
}
