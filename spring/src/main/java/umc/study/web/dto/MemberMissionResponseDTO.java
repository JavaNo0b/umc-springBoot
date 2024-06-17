package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResponseDTO {

    // 미션 추가
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChallengeResultDTO{
        Long memberMissionId;
        LocalDateTime createAt;
    }

    //도전 중인 미션 조회(페이징)
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChallengeMissionListDTO{
        List<MemberMissionResponseDTO.ChallengeMissionDTO> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    //도전 중인 미션
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChallengeMissionDTO{
        String storeName;
        String missionSpec;
        Integer reward;
        LocalDate deadLine;
    }
}
