package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.service.MemberCommandService;
import umc.study.validation.annotation.CheckMissionStatus;

@Component
@RequiredArgsConstructor
public class MissionStatusCheckValidator implements ConstraintValidator<CheckMissionStatus, Long> {

    private final MemberCommandService memberCommandService;

    @Override
    public void initialize(CheckMissionStatus constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        // 미션아이디를 넣어 해당하는 멤버미션이 있는 지 확인
        boolean isValid = memberCommandService.existMemberMission(value);

        //미션 아이디를 넣고 멤버 1과 겹치는 멤버미션이 있는지 확인하고 도전중이 아니면 false
        boolean isChallenge = memberCommandService.isChallengeMission(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBERMISSION_NOT_FOUND.toString()).addConstraintViolation();
        } else if (isChallenge) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBERMISSION_CHALLENGE.toString()).addConstraintViolation();
        }
        return false;
    }
}
