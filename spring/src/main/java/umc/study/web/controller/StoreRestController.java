package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.service.StoreService;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreService storeService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.JoinStoreResultDTO> joinStore(@RequestParam Long regionId,
                                                                 @RequestBody @Valid StoreRequestDTO.JoinStoreDTO request) {
        Store newStore = storeService.joinStore(request, regionId);
        return ApiResponse.onSuccess(StoreConverter.toJoinStoreResultDTO(newStore));
    }
}
