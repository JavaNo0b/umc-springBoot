package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.MemberExistValidator;
import umc.study.validation.validator.PageCheckValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageCheckValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {

    String message() default "페이지를 확인하세요.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
