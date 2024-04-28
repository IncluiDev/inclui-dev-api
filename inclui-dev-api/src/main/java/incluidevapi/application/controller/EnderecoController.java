package incluidevapi.application.controller;

import incluidevapi.application.service.EnderecoService;
import incluidevapi.data.dto.post.EnderecoPostDto;
import incluidevapi.data.dto.put.EnderecoPutDto;
import incluidevapi.data.model.persist.perfil.EnderecoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoController {
    private final EnderecoService enderecoService;

    @PostMapping("")
    public ResponseEntity<EnderecoModel> save(@RequestBody EnderecoPostDto endereco) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(endereco));
    }

    @PutMapping("")
    public ResponseEntity<EnderecoModel> update(@RequestBody EnderecoPutDto endereco) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.update(endereco));
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestParam UUID id) {
        enderecoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("")
    public ResponseEntity<EnderecoModel> findById(@RequestParam UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findById(id));
    }

    @GetMapping("/usuario")
    public ResponseEntity<EnderecoModel> findByUsuario(@RequestParam UUID usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findByUsuario(usuario));
    }
}
