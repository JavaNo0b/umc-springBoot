package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.domain.Region;

public class StoreRequestDTO {

    @Getter
    public static class JoinStoreDTO{
        @NotBlank
        String name;
        @Size(min = 3, max = 30)
        String address;
    }
}
