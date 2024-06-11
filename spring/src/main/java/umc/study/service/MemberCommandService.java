package umc.study.service;

import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.ReviewRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);

    @Transactional
    Review createReview(ReviewRequestDTO.CreateDTO request, Long storeId, Long memberId);
}
