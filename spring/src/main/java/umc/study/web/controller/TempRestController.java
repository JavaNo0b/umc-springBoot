package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.TempConverter;
import umc.study.web.dto.TempResponse;


@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }
}

//@RestController:
//
//이 어노테이션은 이 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타냅니다. Spring은 이 어노테이션을 사용하여 해당 클래스의 메서드들이 HTTP 요청을 처리하도록 만듭니다.
//이 어노테이션은 자동으로 메서드의 반환값을 JSON 또는 XML 형식으로 변환하여 HTTP 응답으로 보냅니다.

//@RequiredArgsConstructor:
//
//Lombok 라이브러리의 어노테이션으로, final 필드나 @NonNull 필드에 대한 생성자를 자동으로 생성합니다. 이 컨트롤러 클래스에서는 주입된 의존성을 처리하는데 사용됩니다.