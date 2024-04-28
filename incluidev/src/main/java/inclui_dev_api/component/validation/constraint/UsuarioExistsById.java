package inclui_dev_api.component.validation.constraint;

import inclui_dev_api.component.validation.constraintValidator.UsuarioExistsByIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsuarioExistsByIdValidator.class)
public @interface UsuarioExistsById {
    String message() default "<mensagem>";
    Class<?>[ ] groups() default { };
    Class<? extends Payload>[ ] payload() default { };
}