package umc.study.service;

import umc.study.domain.Member;
import umc.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
}
