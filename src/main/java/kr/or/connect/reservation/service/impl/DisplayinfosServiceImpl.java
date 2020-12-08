package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.DisplayinfosDAO;
import kr.or.connect.reservation.dto.DisplayinfosDTO;
import kr.or.connect.reservation.service.DisplayinfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DisplayinfosServiceImpl implements DisplayinfosService {
    @Autowired
    DisplayinfosDAO displayinfosDAO;
    @Override
    @Transactional(readOnly = true)
    public List<DisplayinfosDTO> getDisplayInfos(Integer categoryId) {
        List<DisplayinfosDTO> displayinfosDTOList = displayinfosDAO.getDisplayInfos(categoryId,DisplayinfosService.START);
        return displayinfosDTOList;
    }
}
