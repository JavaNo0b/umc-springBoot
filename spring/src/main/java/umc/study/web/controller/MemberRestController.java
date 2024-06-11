package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberCommandService;
import umc.study.service.MemberCommandServiceImpl;
import umc.study.web.dto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.CreateResultDTO> create(@RequestBody @Valid ReviewRequestDTO.CreateDTO request,
                                                                 @PathVariable Long storeId,
                                                                 @RequestParam Long memberId){

        Review newReview =  memberCommandService.createReview(request, storeId, memberId);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDTO(newReview));
    }

    @PostMapping("/missions/{missionId}/challenging")
    public ApiResponse<MemberMissionResponseDTO.ChallengeResultDTO> challenge(@PathVariable Long missionId,
                                                                              @RequestParam Long memberId){

        MemberMission newChallenge = memberCommandService.createChallenge(missionId, memberId);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeResultDTO(newChallenge));
    }
}
