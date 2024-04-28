package incluidevapi.component.validation.constraintValidator;

import incluidevapi.application.repository.TelefoneRepository;
import incluidevapi.component.validation.constraint.TelefoneExistsById;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class TelefoneExistsByIdValidator implements ConstraintValidator<TelefoneExistsById, UUID> {
    private final TelefoneRepository telefoneRepository;

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext constraintValidatorContext) {
        return existsTelefone(value);
    }

    private boolean existsTelefone(UUID id){
        return telefoneRepository.existsById(id);
    }
}