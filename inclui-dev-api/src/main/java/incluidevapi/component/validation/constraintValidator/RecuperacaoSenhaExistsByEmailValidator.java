package incluidevapi.component.validation.constraintValidator;

import incluidevapi.application.repository.RecuperacaoSenhaRepository;
import incluidevapi.component.validation.constraint.RecuperacaoSenhaExistsByEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecuperacaoSenhaExistsByEmailValidator implements ConstraintValidator<RecuperacaoSenhaExistsByEmail, String> {
    private final RecuperacaoSenhaRepository recuperacaoSenhaRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return existsRecuperacao(value);
    }

    private boolean existsRecuperacao(String email){
        return recuperacaoSenhaRepository.existsByEmail(email);
    }
}