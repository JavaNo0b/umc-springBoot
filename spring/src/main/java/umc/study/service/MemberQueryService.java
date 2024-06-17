package umc.study.service;

import org.springframework.data.domain.Page;
import umc.study.domain.mapping.MemberMission;

public interface MemberQueryService {

    Page<MemberMission> getChallengingMissionList(Long memberId, Integer page);

}
