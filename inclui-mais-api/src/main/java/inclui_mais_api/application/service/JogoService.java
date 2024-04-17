package inclui_mais_api.application.service;

import inclui_mais_api.application.repository.JogoRepository;
import inclui_mais_api.component.exception.ExceptionGeneric;
import inclui_mais_api.component.exception.NotFoundException;
import inclui_mais_api.data.dto.post.JogoPostDto;
import inclui_mais_api.data.mapper.JogoMapper;
import inclui_mais_api.data.model.persist.educacional.JogoModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JogoService {
    private final JogoRepository JogoRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public JogoModel save(@Valid JogoPostDto jogo) {
        return JogoRepository.save(JogoMapper.toMapper(jogo));
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID jogo) {
        try {
            JogoRepository.deleteById(jogo);
        } catch (Exception ignored) { }
    }

    /*
    public JogoModel update(@Valid JogoPostDto Jogo) {
        return JogoRepository.save(
                JogoMapper.toMapper(Jogo, findById(Jogo.getId())));
    }
    */

    public JogoModel findById(UUID jogo) {
        return JogoRepository.findById(jogo).orElseThrow(
                () -> new NotFoundException("Jogo")
        );
    }
}
