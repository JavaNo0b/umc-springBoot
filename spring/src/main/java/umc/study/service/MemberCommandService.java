package umc.study.service;

import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.ReviewRequestDTO;

public interface MemberCommandService {
    boolean existMemberId(Long id);

    boolean existMemberMission(Long id);

    boolean isChallengeMission(Long missionId);

    Member joinMember(MemberRequestDTO.JoinDTO request);

    @Transactional
    Review createReview(ReviewRequestDTO.CreateDTO request, Long storeId, Long memberId);

    @Transactional
    MemberMission createChallenge(Long missionId, Long memberId);
}
