package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.Gender;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberMissionResponseDTO;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
                .build();


    }
}
