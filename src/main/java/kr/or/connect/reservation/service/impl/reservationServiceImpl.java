package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.reservationDAO;
import kr.or.connect.reservation.dto.ReservationBody;
import kr.or.connect.reservation.dto.api.reservationApiDTO;
import kr.or.connect.reservation.dto.reservationPriceDto;
import kr.or.connect.reservation.service.reservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class reservationServiceImpl implements reservationService {

    private final reservationDAO reservationDao;



    @Override
    @Transactional(readOnly = true)
    public reservationApiDTO getResInfo(ReservationBody reservation) {
        reservationApiDTO apiDTO = new reservationApiDTO();
        apiDTO.setPrices(reservationDao.insertResPrice());
        apiDTO
        return null;
    }

    @Override
    public reservationPriceDto getPrice(reservationPriceDto reservationPriceDto) {
        return null;
    }
}
