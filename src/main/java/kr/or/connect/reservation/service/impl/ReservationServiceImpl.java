package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.ReservationInfoDAO;
import kr.or.connect.reservation.dao.ReservationPriceDAO;
import kr.or.connect.reservation.dao.ReservationResponseDAO;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import kr.or.connect.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationPriceDAO reservationPriceDAO;
    private final ReservationInfoDAO reservationInfoDAO;
    private final ReservationResponseDAO reservationResponseDAO;


    @Override
    public int insertReservationInfo(ReservationApiDTO reservationApiDTO) {
        return 0;
    }

    @Override
    @Transactional(readOnly = false)
    public ReservationApiDTO insertInfoAndPrices(ReservationApiDTO reservationApiDTO) {
        int reservationInfoId = insertReservationInfo(reservationApiDTO);
        insertReservationPrice(reservationApiDTO, reservationInfoId);

        return getReservationResponse(reservationInfoId);
    }

    @Override
    public void insertReservationPrice(ReservationApiDTO reservationApiDTO, int reservationInfoId) {
        List<ReservationPrice> reservationPrices = reservationApiDTO.getPrices();

        for (ReservationPrice reservationPrice : reservationPrices) {
            reservationPrice.setReservationInfoId(reservationInfoId);
            reservationPriceDAO.insertReservationPrice(reservationPrice);
        }
    }

    @Override
    public List<ReservationPrice> getReservationPrice(int reservationInfoId) {
        return reservationPriceDAO.getReservationPrice(reservationInfoId);
    }

    @Override
    public ReservationApiDTO getReservationResponse(int reservationInfoId) {
        ReservationApiDTO reservationApiDTO = reservationResponseDAO.getReservationResponse(reservationInfoId);
        reservationApiDTO.setPrices(getReservationPrice(reservationInfoId));

        return reservationApiDTO;
    }


}
