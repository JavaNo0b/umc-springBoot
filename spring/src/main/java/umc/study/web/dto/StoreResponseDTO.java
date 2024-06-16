package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class StoreResponseDTO {

    // 지역에 가게 추가
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinStoreResultDTO{
        Long storeId;
        LocalDateTime createdAt;
    }


    // 리뷰 목록 리스트 조회(페이징)
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO{
        List<ReviewPreViewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
    // 리뷰 목록
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewDTO{
        String ownerNickname; //멤버의 정보가 닉네임 말고도 많이 필요하다면 이렇게도 가능 MemberInfoDTO memberInfo;
        Float score;
        String body;
        LocalDate createdAt;
    }
}
