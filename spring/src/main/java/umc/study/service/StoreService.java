package umc.study.service;

import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;

public interface StoreService {
    Store joinStore(StoreRequestDTO.JoinStoreDTO request, Long regionId);
}
