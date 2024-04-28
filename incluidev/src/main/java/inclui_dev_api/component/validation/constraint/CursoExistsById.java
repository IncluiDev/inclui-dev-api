package inclui_dev_api.component.validation.constraint;

import inclui_dev_api.component.validation.constraintValidator.CursoExistsByIdValidator;
import inclui_dev_api.component.validation.constraintValidator.JogoExistsByIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CursoExistsByIdValidator.class)
public @interface CursoExistsById {
    String message() default "<mensagem>";
    Class<?>[ ] groups() default { };
    Class<? extends Payload>[ ] payload() default { };
}