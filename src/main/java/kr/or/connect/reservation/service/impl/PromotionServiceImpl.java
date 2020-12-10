package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.PromotionDAO;
import kr.or.connect.reservation.dto.api.PromotionApiDto;
import kr.or.connect.reservation.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService {

    private final PromotionDAO promotionDAO;

    @Override
    @Transactional(readOnly = true)
    public PromotionApiDto getPromotions() {
        return promotionDAO.getPromotionList();
    }
}

