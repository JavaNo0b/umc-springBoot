package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;

    private final ReviewRepository reviewRepository;

    private final MissionRepository missionRepository;


    @Override
    public Optional<Store> findStore(Long storeId) {
        return storeRepository.findById(storeId);
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {

        Store store = storeRepository.findById(storeId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {

        Store store = storeRepository.findById(storeId).get();

        Page<Mission> StorePage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }
}
