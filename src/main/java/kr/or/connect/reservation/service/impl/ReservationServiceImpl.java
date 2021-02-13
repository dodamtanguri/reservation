package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.ReservationInfoDAO;
import kr.or.connect.reservation.dao.ReservationPriceDAO;
import kr.or.connect.reservation.dao.ReservationResponseDAO;
import kr.or.connect.reservation.dto.ReservationInfo;
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
    public int requestReservationInfo(ReservationApiDTO reservationApiDTO) {
        return reservationInfoDAO.insertReservationInfo(reservationApiDTO);
    }

    @Override
    @Transactional(readOnly = false)
    public void requestInfoAndPrices(ReservationApiDTO reservationApiDTO) {
        int reservationInfoId = requestReservationInfo(reservationApiDTO);
        requestPrices(reservationApiDTO, reservationInfoId);
    }

    @Override
    @Transactional(readOnly = false)
    public void requestPrices(ReservationApiDTO reservationApiDTO, int reservationInfoId) {
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
    public ReservationApiDTO getReservationInfo(int reservationInfoId) {
        return reservationInfoDAO.getReservationInfo(reservationInfoId);

    }

    @Override
    public ReservationApiDTO responseReservation(int reservationInfoId, int userId) {
        ReservationApiDTO apiDTO = reservationInfoDAO.getReservationInfo(reservationInfoId);
        apiDTO.setPrices(getReservationPrice(reservationInfoId));


        return apiDTO;
    }


}
