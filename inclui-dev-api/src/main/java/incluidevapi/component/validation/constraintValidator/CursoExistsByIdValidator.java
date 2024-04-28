package incluidevapi.component.validation.constraintValidator;

import incluidevapi.application.repository.CursoRepository;
import incluidevapi.component.validation.constraint.CursoExistsById;
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