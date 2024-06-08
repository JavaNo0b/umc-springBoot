package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.CategoriesExistValidator;

import java.lang.annotation.*;

//사용자 정의 어노테이션
@Documented
//validation을 커스텀 어노테이션을 통해 할 수 있도록 제공하는 어노테이션 /  CategoriesExistValidator라는 클래스를 통해 @ExistCategories가 붙은 대상을 검증
@Constraint(validatedBy = CategoriesExistValidator.class)
//어노테이션의 적용 범위를 지정
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
//어노테이션의 생명 주기를 지정
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

