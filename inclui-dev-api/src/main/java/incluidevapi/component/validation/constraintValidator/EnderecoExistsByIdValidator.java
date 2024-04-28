package incluidevapi.component.validation.constraintValidator;

import incluidevapi.application.repository.EnderecoRepository;
import incluidevapi.component.validation.constraint.EnderecoExistsById;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class EnderecoExistsByIdValidator implements ConstraintValidator<EnderecoExistsById, UUID> {
    private final EnderecoRepository enderecoRepository;

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext constraintValidatorContext) {
        return existsEndereco(value);
    }

    private boolean existsEndereco(UUID id){
        return enderecoRepository.existsById(id);
    }
}