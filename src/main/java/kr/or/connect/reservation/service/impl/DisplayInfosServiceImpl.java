package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.DisplayInfosDAO;
import kr.or.connect.reservation.dto.api.DisplayInfosApiDTO;
import kr.or.connect.reservation.service.DisplayInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class DisplayInfosServiceImpl implements DisplayInfoService {

    private final DisplayInfosDAO displayInfosDAO;

    @Override
    @Transactional(readOnly = true)
    public DisplayInfosApiDTO getDisplayInfos(int displayInfoId) {
        DisplayInfosApiDTO displayInfosApiDTO = new DisplayInfosApiDTO();
        displayInfosApiDTO.setProduct(displayInfosDAO.getProduct(displayInfoId));
        displayInfosApiDTO.setProductImage(displayInfosDAO.getProductImage(displayInfoId));
        displayInfosApiDTO.setDisplayImage(displayInfosDAO.getDisplayinfoImage(displayInfoId));
        displayInfosApiDTO.setAvgScore(displayInfosDAO.avgScore(displayInfoId));
        displayInfosApiDTO.setProductPrices(displayInfosDAO.getProductPrices(displayInfoId));
        return displayInfosApiDTO;
    }
}
