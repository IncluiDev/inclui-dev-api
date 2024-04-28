package inclui_dev_api.component.validation.constraintValidator;

import inclui_dev_api.application.repository.PreferenciaRepository;
import inclui_dev_api.component.validation.constraint.PreferenciaExistsById;
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