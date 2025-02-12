package incluidevapi.application.service;

import incluidevapi.application.repository.JogoRepository;
import incluidevapi.component.exception.ExceptionGeneric;
import incluidevapi.component.exception.NotFoundException;
import incluidevapi.data.dto.post.JogoPostDto;
import incluidevapi.data.dto.put.JogoPutDto;
import incluidevapi.data.mapper.JogoMapper;
import incluidevapi.data.model.persist.educacional.JogoModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JogoService {
    private final JogoRepository jogoRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public JogoModel save(@Valid JogoPostDto jogo) {
        return jogoRepository.save(JogoMapper.toMapper(jogo));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID jogo) {
        try {
            jogoRepository.deleteById(jogo);
        } catch (Exception ignored) { }
    }

    public JogoModel update(@Valid JogoPutDto jogo) {
        return jogoRepository.save(
                JogoMapper.toMapper(findById(jogo.getId()), jogo)
        );
    }

    public JogoModel findById(UUID jogo) {
        return jogoRepository.findById(jogo).orElseThrow(
                () -> new NotFoundException("Jogo")
        );
    }
}
