package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class CreateDTO{
        @NotNull
        String title;
        @Size(min = 5, max = 40)
        String body;
        @NotNull
        Float score;
    }
}
