package umc.study.service;

import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;

public interface StoreService {
    boolean existStore(Long id);

    Store joinStore(StoreRequestDTO.JoinStoreDTO request, Long regionId);
}
