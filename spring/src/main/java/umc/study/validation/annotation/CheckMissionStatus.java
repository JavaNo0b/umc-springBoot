package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.Payload;
import umc.study.validation.validator.MissionStatusCheckValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionStatusCheckValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckMissionStatus{

    String message() default "해당 미션이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
