package incluidevapi.component.validation.constraintValidator;

import incluidevapi.application.repository.ProgressoRepository;
import incluidevapi.component.validation.constraint.ProgressoExistsById;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ProgressoExistsByIdValidator implements ConstraintValidator<ProgressoExistsById, UUID> {
    private final ProgressoRepository progressoRepository;

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext constraintValidatorContext) {
        return existsProgresso(value);
    }

    private boolean existsProgresso(UUID id){
        return progressoRepository.existsById(id);
    }
}