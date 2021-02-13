package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.ReservationInfoDAO;
import kr.or.connect.reservation.dao.ReservationPriceDAO;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.service.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationPriceDAO reservationPriceDAO;
    private final ReservationInfoDAO reservationInfoDAO;


    @Override
    public int requestReservationInfo(ReservationApiDTO reservationApiDTO) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        reservationApiDTO.setUserId(customUserDetails.getUserId());
        return reservationInfoDAO.insertReservationInfo(reservationApiDTO);
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
    @Transactional(readOnly = false)
    public void requestInfoAndPrices(ReservationApiDTO reservationApiDTO) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        reservationApiDTO.setUserId(customUserDetails.getUserId());
        int reservationInfoId = reservationApiDTO.getId();
        requestPrices(reservationApiDTO, reservationInfoId);
    }



//
//    @Override
//    public List<ReservationPrice> getReservationPrice(int reservationInfoId) {
//
//        return reservationPriceDAO.getReservationPrice(reservationInfoId);
//    }
//
//    @Override
//    public ReservationApiDTO getReservationInfo(int userID) {
//        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        userID = customUserDetails.getUserId();
//        return reservationInfoDAO.getReservationInfo(userID);
//
//    }

    @Override
    public ReservationApiDTO responseReservation(int userID,int reservationInfoId) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userID = customUserDetails.getUserId();
        ReservationApiDTO apiDTO = reservationInfoDAO.getReservationInfo(userID);
        List<ReservationPrice> reservationPrices = reservationPriceDAO.getReservationPrice(reservationInfoId);
        apiDTO.setPrices(reservationPrices);
        return apiDTO;
    }


}
