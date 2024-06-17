package umc.study.service;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    //Optional<Store>: 조회된 가게를 반환합니다. 가게가 존재하지 않을 경우, Optional.empty()를 반환하여 null을 방지
    Optional<Store> findStore(Long storeId);

    //Page : 페이지네이션된 결과를 담는 컨테이너입니다. 이는 Review 객체의 리스트를 페이지 단위로 나누어 담고 있으며, 페이지네이션과 관련된 다양한 메타 데이터를 포함
    Page<Review> getReviewList(Long storeId, Integer page);
}
