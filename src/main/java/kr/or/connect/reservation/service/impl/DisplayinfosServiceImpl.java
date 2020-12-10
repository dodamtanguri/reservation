package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.DisplayinfosDAO;
import kr.or.connect.reservation.dto.api.DisplayinfosApiDto;
import kr.or.connect.reservation.service.DisplayinfosService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class DisplayinfosServiceImpl implements DisplayinfosService {

    private final DisplayinfosDAO displayinfosDAO;

    @Override
    @Transactional(readOnly = true)
    public DisplayinfosApiDto getDisplayInfos(int categoryId) {
        DisplayinfosApiDto displayinfosApiDto = new DisplayinfosApiDto();
        displayinfosApiDto.setProducts(displayinfosDAO.getDisplayInfos(categoryId, DisplayinfosService.START));
        displayinfosApiDto.setTotalCount(displayinfosDAO.getTotalCount(categoryId));
        return displayinfosApiDto;
    }


}
