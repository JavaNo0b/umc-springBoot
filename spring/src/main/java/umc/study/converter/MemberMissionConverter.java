package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberMissionResponseDTO;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.ChallengeResultDTO toChallengeResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.ChallengeResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    //    Member 객체를 만드는 작업 (클라이언트가 준 DTO to Entity)
    public static MemberMission toMemberMission(Mission mission, Member member){


        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();


    }

    public static MemberMissionResponseDTO.ChallengeMissionDTO toChallengingMissionDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.ChallengeMissionDTO.builder()
                .storeName(memberMission.getMission().getStore().getName())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .reward(memberMission.getMission().getReward())
                .deadLine(memberMission.getMission().getDeadline())
                .build();
    }

    public static MemberMissionResponseDTO.ChallengeMissionListDTO toChallengingMissionListDTO(Page<MemberMission> memberMissionList) {

        List<MemberMissionResponseDTO.ChallengeMissionDTO> missionDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::toChallengingMissionDTO).collect(Collectors.toList());

        return MemberMissionResponseDTO.ChallengeMissionListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(missionDTOList.size())
                .missionList(missionDTOList)
                .build();
    }
}
