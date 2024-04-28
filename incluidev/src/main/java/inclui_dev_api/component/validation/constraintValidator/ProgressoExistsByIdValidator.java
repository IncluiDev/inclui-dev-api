package inclui_dev_api.component.validation.constraintValidator;

import inclui_dev_api.application.repository.ProgressoRepository;
import inclui_dev_api.component.validation.constraint.ProgressoExistsById;
import inclui_dev_api.component.validation.constraint.UsuarioExistsById;
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