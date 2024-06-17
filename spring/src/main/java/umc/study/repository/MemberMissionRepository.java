package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsMemberMissionByMissionId(Long missionId);
    MemberMission findMemberMissionByMemberIdAndMissionId(Long memberId, Long missionId);
    List<MemberMission> findAllByMemberIdAndStatus(Long memberId, MissionStatus status);

    Page<MemberMission> findAllByMemberIdAndStatus(Long memberId, MissionStatus status, PageRequest pageRequest);
}
