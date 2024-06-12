package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.converter.StoreConverter;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public boolean existStore(Long id){
        return storeRepository.existsById(id);
    }

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.JoinStoreDTO request, Long regionId){

        Region region = regionRepository.findById(regionId).orElseThrow(() -> new GeneralException(ErrorStatus.REGION_ID_NOT_FOUND));

        Store newStore = StoreConverter.toStore(request, region);


        return storeRepository.save(newStore);
    }

}
