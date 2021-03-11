package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.ReservationDAO;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.service.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationDAO dao;


    @Override
    public void insertReservationInfo(ReservationApiDTO reservationInfo) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        reservationInfo.setUserId(customUserDetails.getUserId());
        dao.insertReservationInfo(reservationInfo);

    }


    @Override
    @Transactional(readOnly = true)
    public int selectReservationInfoId(ReservationApiDTO reservationInfo) {
        return dao.getReservationInfo(reservationInfo.getUserId()).getId();
    }


    @Override
    @Transactional(readOnly = false)
    public void insertPrices(ReservationPrice reservationPrice, int reservationId) {
        reservationPrice.setReservationInfoId(reservationId);
        dao.insertReservationPrice(reservationPrice);
    }


    @Override
    public ReservationApiDTO responseReservation(ReservationApiDTO reservationInfo, int reservationId) {
        dao.getReservationInfo(reservationInfo.getUserId());
        reservationInfo.setId(reservationId);
        reservationInfo.setPrices(dao.getReservationPrice(reservationId));
        return reservationInfo;
    }


}
