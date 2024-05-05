package incluidevapi.component.validation.constraint;

import incluidevapi.component.validation.constraintValidator.RecuperacaoSenhaExistsByEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RecuperacaoSenhaExistsByEmailValidator.class)
public @interface RecuperacaoSenhaExistsByEmail {
    String message() default "<mensagem>";
    Class<?>[ ] groups() default { };
    Class<? extends Payload>[ ] payload() default { };
}