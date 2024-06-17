package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Region;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDTO.JoinStoreResultDTO toJoinStoreResultDTO(Store store) {
        return StoreResponseDTO.JoinStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinStoreDTO request, Region region){

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO toReviewPreViewDTO(Review review) {
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .body(review.getBody())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> reviewList) {

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::toReviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionDTO toMissionDTO(Mission mission) {
        return StoreResponseDTO.MissionDTO.builder()
                .storeName(mission.getStore().getName())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadLine(mission.getDeadline())
                .build();
    }

    public static StoreResponseDTO.MissionListDTO toMissionListDTO(Page<Mission> missionList) {

        List<StoreResponseDTO.MissionDTO> missionDTOList = missionList.stream()
                .map(StoreConverter::toMissionDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionDTOList.size())
                .missionList(missionDTOList)
                .build();
    }


}
