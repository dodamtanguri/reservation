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
        return reservationInfo;
    }


    /*
    Price Insert
    어짜피 Insert하는건데 그냥 여기서 리턴 안해줘도 select해올때 상관 없는거 아닌지
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
