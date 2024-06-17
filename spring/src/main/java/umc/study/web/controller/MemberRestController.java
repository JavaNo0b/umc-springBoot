package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.converter.StoreConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberCommandService;
import umc.study.service.MemberCommandServiceImpl;
import umc.study.service.MemberQueryService;
import umc.study.validation.annotation.CheckMissionStatus;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.CreateResultDTO> create(@RequestBody @Valid ReviewRequestDTO.CreateDTO request,
                                                                 @ExistStore @PathVariable Long storeId,
                                                                 @ExistMember @RequestParam Long memberId){

        Review newReview =  memberCommandService.createReview(request, storeId, memberId);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDTO(newReview));
    }

    @PostMapping("/missions/{missionId}/challenging")
    public ApiResponse<MemberMissionResponseDTO.ChallengeResultDTO> challenge(@PathVariable @CheckMissionStatus Long missionId,
                                                                              @RequestParam @ExistMember Long memberId){

        MemberMission newChallenge = memberCommandService.createChallenge(missionId, memberId);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeResultDTO(newChallenge));
    }

    @GetMapping("/missions/challenging")
    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "유저의 아이디입니다. auth가 없으므로 1로 대체합니다."),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<MemberMissionResponseDTO.ChallengeMissionListDTO> getChallengingMissionList(
                                                                       @RequestParam(name = "memberId") Long memberId,
                                                                       @CheckPage @RequestParam(name = "page") Integer page) {
        Page<MemberMission> MissionPage = memberQueryService.getChallengingMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengingMissionListDTO(MissionPage));
    }
}
