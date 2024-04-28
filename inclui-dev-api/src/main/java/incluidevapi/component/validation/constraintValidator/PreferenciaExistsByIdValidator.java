package incluidevapi.component.validation.constraintValidator;

import incluidevapi.application.repository.PreferenciaRepository;
import incluidevapi.component.validation.constraint.PreferenciaExistsById;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class PreferenciaExistsByIdValidator implements ConstraintValidator<PreferenciaExistsById, UUID> {
    private final PreferenciaRepository preferenciaRepository;

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext constraintValidatorContext) {
        return existsPreferencia(value);
    }

    private boolean existsPreferencia(UUID id){
        return preferenciaRepository.existsById(id);
    }
}