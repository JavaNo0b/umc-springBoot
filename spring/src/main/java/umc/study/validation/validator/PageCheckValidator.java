package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.ReviewRepository;
import umc.study.validation.annotation.CheckPage;

@Component
@RequiredArgsConstructor
public class PageCheckValidator implements ConstraintValidator<CheckPage, Integer> {

    private final ReviewRepository reviewRepository;

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {

        if (page < 0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NOT_EXIST.toString()).addConstraintViolation();
            return false;
        }

        return true;
    }
}
