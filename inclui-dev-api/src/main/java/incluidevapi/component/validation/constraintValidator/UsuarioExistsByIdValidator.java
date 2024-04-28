package incluidevapi.component.validation.constraintValidator;

import incluidevapi.application.repository.UsuarioRepository;
import incluidevapi.component.validation.constraint.UsuarioExistsById;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UsuarioExistsByIdValidator implements ConstraintValidator<UsuarioExistsById, UUID> {
    private final UsuarioRepository usuarioRepository;

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext constraintValidatorContext) {
        return existsUsuario(value);
    }

    private boolean existsUsuario(UUID id){
        return usuarioRepository.existsById(id);
    }
}