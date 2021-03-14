package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.ReservationDAO;
import kr.or.connect.reservation.dto.Body.CancelBody;
import kr.or.connect.reservation.dto.Body.ReservationBody;
import kr.or.connect.reservation.dto.CancelReservation;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.api.GetReservationInfoApiDTO;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.service.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationDAO dao;


    @Override
    public ReservationApiDTO insertReservationInfo(ReservationBody req) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        ReservationApiDTO apiDTO = new ReservationApiDTO();
        apiDTO.setUserId(customUserDetails.getUserId());
        apiDTO.setProductId(req.getProductId());
        apiDTO.setDisplayInfoId(req.getDisplayInfoId());
        apiDTO.setReservationDate(req.getReservationYearMonthDay());

        int reservationInfoId = dao.insertReservationInfo(apiDTO);

        ReservationPrice priceDTO = new ReservationPrice();
        priceDTO.setReservationInfoId(reservationInfoId);
        priceDTO.setCount(req.getPrices().get(0).getCount());
        priceDTO.setProductPriceId(req.getPrices().get(0).getProductPriceId());

        int reservationPriceId = dao.insertReservationPrice(priceDTO);


        dao.getReservationInfo(reservationInfoId);
        apiDTO.setId(reservationInfoId);
        apiDTO.setPrices(dao.getReservationPrice(reservationPriceId));


        return apiDTO;


    }


    @Override
    public GetReservationInfoApiDTO getReservation() {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        GetReservationInfoApiDTO apiDTO = new GetReservationInfoApiDTO();
        int userID = customUserDetails.getUserId();
        apiDTO.setItems(dao.getReservationInfoApiDTO(userID));
        return apiDTO;
    }

    @Override
    public CancelReservation cancelReservation(CancelBody req) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int status = dao.cancelReservation(req.getId(), customUserDetails.getUserId());

        CancelReservation cancelReservation = new CancelReservation();
        if (status == 0) {
            cancelReservation.setResult("fail");
        } else {
            cancelReservation.setResult("Success");
        }


        return cancelReservation;
    }
}