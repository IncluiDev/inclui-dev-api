package inclui_dev_api.component.validation.constraintValidator;

import inclui_dev_api.application.repository.UsuarioRepository;
import inclui_dev_api.component.validation.constraint.UsuarioExistsByEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsuarioExistsByEmailValidator implements ConstraintValidator<UsuarioExistsByEmail, String> {
    private final UsuarioRepository usuarioRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return existsUsuario(value);
    }

    private boolean existsUsuario(String email){
        return usuarioRepository.existsByEmail(email);
    }
}