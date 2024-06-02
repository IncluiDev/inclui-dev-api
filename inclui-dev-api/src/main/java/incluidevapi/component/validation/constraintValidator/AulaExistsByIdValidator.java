package incluidevapi.component.validation.constraintValidator;

import incluidevapi.application.repository.AulaRepository;
import incluidevapi.component.validation.constraint.CursoExistsById;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class AulaExistsByIdValidator implements ConstraintValidator<CursoExistsById, UUID> {
    private final AulaRepository aulaRepository;

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext constraintValidatorContext) {
        return existsAula(value);
    }

    private boolean existsAula(UUID id){
        return aulaRepository.existsById(id);
    }
}