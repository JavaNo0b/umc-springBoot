package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsMemberMissionByMissionId(Long missionId);
    MemberMission findMemberMissionByMemberIdAndMissionId(Long memberId, Long missionId);
}
