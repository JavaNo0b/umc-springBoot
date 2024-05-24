package umc.study.converter;

import umc.study.web.dto.TempResponse;

//TempResponse.TempTestDTO 타입의 객체를 생성하여 반환
//컨버터 함수 이름은 to<만들려는 대상>

public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}

//이 코드는 TempConverter 클래스 내의 toTempTestDTO 정적 메서드를 통해
//TempResponse.TempTestDTO 객체를 생성하고 반환합니다.
//이 객체는 "This is Test!"라는 문자열을 testString 속성으로 포함하고 있으며,
//객체 생성에는 빌더 패턴이 사용됩니다.