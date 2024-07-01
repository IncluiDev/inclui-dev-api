package incluidevapi.application.service;

import incluidevapi.application.repository.AulaRepository;
import incluidevapi.application.repository.ProgressoRepository;
import incluidevapi.component.exception.ExceptionGeneric;
import incluidevapi.component.exception.NotFoundException;
import incluidevapi.data.dto.post.ProgressoPostDto;
import incluidevapi.data.dto.put.ProgressoPutDto;
import incluidevapi.data.mapper.ProgressoMapper;
import incluidevapi.data.model.persist.usabilidade.ProgressoModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProgressoService {
    private final ProgressoRepository progressoRepository;
    private final AulaRepository aulaRepository;

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public ProgressoModel save(@Valid ProgressoPostDto progresso) {
        return addProgressPorcentage(
                progressoRepository.save(ProgressoMapper.toMapper(progresso))
        );
    }

    @Transactional(rollbackOn = ExceptionGeneric.class)
    public void delete(UUID progresso) {
        try {
            progressoRepository.deleteById(progresso);
        } catch (Exception ignored) { }
    }

    public ProgressoModel update(@Valid ProgressoPutDto progresso) {
        var progressoObject = progressoRepository.findByUsuarioAndEducativo(progresso.getUsuario(), progresso.getEducativo()).orElseThrow(
                    () -> new NotFoundException("Progresso")
            );

        progressoObject.setProgresso(progresso.getProgresso());

        return addProgressPorcentage(
                progressoRepository.save(progressoObject)
        );
    }

    public ProgressoModel findById(UUID progresso) {
        return addProgressPorcentage(progressoRepository.findById(progresso).orElseThrow(
                () -> new NotFoundException("Progresso")
        ));
    }

    public List<ProgressoModel> findByUsuario(UUID usuario) {
        return progressoRepository.findAllByUsuario(usuario).orElseThrow(
                () -> new NotFoundException("Progresso")
        );
    }

    public ProgressoModel check(UUID usuario, UUID educativo) {
        return addProgressPorcentage(
                progressoRepository.findByUsuarioAndEducativo(usuario, educativo).orElseThrow(
                        () -> new NotFoundException("Progresso")
                ));
    }

    private ProgressoModel addProgressPorcentage(ProgressoModel progresso) {
        try {
            progresso.setPorcentagem(
                    (
                            progresso.getProgresso() / aulaRepository.countAulasByCurso(progresso.getEducativo())
                    ) * 100
            );
        } catch (Exception ignored) {
            progresso.setPorcentagem(0.0);
        }

        return progresso;
    }
}
