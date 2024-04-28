package inclui_dev_api.component.validation.constraintValidator;

import inclui_dev_api.application.repository.JogoRepository;
import inclui_dev_api.component.validation.constraint.JogoExistsById;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class JogoExistsByIdValidator implements ConstraintValidator<JogoExistsById, UUID> {
    private final JogoRepository jogoRepository;

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext constraintValidatorContext) {
        return existsJogo(value);
    }

    private boolean existsJogo(UUID id){
        return jogoRepository.existsById(id);
    }
}