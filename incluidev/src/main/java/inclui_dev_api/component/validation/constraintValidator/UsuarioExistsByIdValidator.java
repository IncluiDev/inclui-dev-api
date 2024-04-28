package inclui_dev_api.component.validation.constraintValidator;

import inclui_dev_api.application.repository.UsuarioRepository;
import inclui_dev_api.component.validation.constraint.UsuarioExistsById;
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