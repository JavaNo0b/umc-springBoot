package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.domain.Region;

public class StoreRequestDTO {

    @Getter
    public static class JoinStoreDTO{
        @NotNull
        String name;
        @NotNull
        String address;
    }
}
