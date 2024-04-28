package inclui_dev_api.component.validation.constraintValidator;

import inclui_dev_api.application.repository.CursoRepository;
import inclui_dev_api.component.validation.constraint.CursoExistsById;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CursoExistsByIdValidator implements ConstraintValidator<CursoExistsById, UUID> {
    private final CursoRepository cursoRepository;

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext constraintValidatorContext) {
        return existsCurso(value);
    }

    private boolean existsCurso(UUID id){
        return cursoRepository.existsById(id);
    }
}