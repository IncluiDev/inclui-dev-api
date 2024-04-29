package incluidevapi.component.validation.constraintValidator;

import incluidevapi.application.repository.UsuarioRepository;
import incluidevapi.component.validation.constraint.UsuarioExistsByEmail;
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