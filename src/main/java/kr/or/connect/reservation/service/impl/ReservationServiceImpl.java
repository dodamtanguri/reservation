package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.ReservationInfoDAO;
import kr.or.connect.reservation.dao.ReservationPriceDAO;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.service.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationPriceDAO reservationPriceDAO;
    private final ReservationInfoDAO reservationInfoDAO;


    @Override
    public ReservationInfo insertReservationInfo(ReservationInfo reservationInfo) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        reservationInfo.setUserId(customUserDetails.getUserId());
        reservationInfoDAO.insertReservationInfo(reservationInfo);
//        reservationInfoDAO.getReservationInfo(customUserDetails.getUserId());
        return reservationInfo;
    }
/*
reservationInfoId select
 */
@Override
@Transactional(readOnly = true)
public ReservationInfo selectReservationInfo(ReservationInfo reservationInfo) {
    return reservationInfoDAO.getReservationInfo(reservationInfo.getUserId());
}
    /*
    Price Insert

     */
    @Override
    @Transactional(readOnly = false)
    public ReservationPrice insertPrices(ReservationInfo reservationInfo) {
        ReservationPrice price = new ReservationPrice();
        price.setReservationInfoId(reservationInfo.getId());
        reservationPriceDAO.insertReservationPrice(price);
        return price;
    }



    /*
    Insert된 데이터 Select
     */
    @Override
    public ReservationApiDTO responseReservation(ReservationInfo reservationInfo) {
        ReservationApiDTO apiDTO = new ReservationApiDTO();
        apiDTO.setPrices(reservationPriceDAO.getReservationPrice(reservationInfo.getId()));
        reservationInfoDAO.getReservationInfo(reservationInfo.getUserId());

        return apiDTO;
    }


}
