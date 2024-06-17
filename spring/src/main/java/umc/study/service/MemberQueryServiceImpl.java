package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<MemberMission> getChallengingMissionList(Long memberId, Integer page) {

        Page<MemberMission> MemberMissionPage = memberMissionRepository.findAllByMemberIdAndStatus(memberId, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
        return MemberMissionPage;
    }
}
