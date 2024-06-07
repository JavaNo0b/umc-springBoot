package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.CategoriesExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoriesExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

//<aside>
//🌟 **@Documented** - ****이 어노테이션은 사용자 정의 어노테이션을 만들 때 붙입니다.
//
//        **@Target** - ****이 어노테이션은 어노테이션의 적용 범위를 지정합니다. 각 파라미터의 자세한 역할은 구글링을 해서 찾아보세용.
//
//**@Retention** - ****이 어노테이션은 어노테이션의 생명 주기를 지정합니다. 위의 코드는 RUNTIME이기에 실행 하는 동안에만 유효하게 됩니다.
//
//</aside>
