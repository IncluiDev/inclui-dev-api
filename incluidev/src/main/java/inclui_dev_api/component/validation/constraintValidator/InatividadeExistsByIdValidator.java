package inclui_dev_api.component.validation.constraintValidator;

import inclui_dev_api.application.repository.InatividadeRepository;
import inclui_dev_api.component.validation.constraint.InatividadeExistsById;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class InatividadeExistsByIdValidator implements ConstraintValidator<InatividadeExistsById, UUID> {
    private final InatividadeRepository inatividadeRepository;

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext constraintValidatorContext) {
        return existsInatividade(value);
    }

    private boolean existsInatividade(UUID id){
        return inatividadeRepository.existsById(id);
    }
}