package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.Body.ReservationBody;
import kr.or.connect.reservation.dto.Body.ReservationPriceBody;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import kr.or.connect.reservation.service.security.UserDbService;

import java.util.List;

public interface ReservationService {
    int requestReservationInfo(ReservationApiDTO reservationApiDTO);

    void requestPrices(ReservationApiDTO reservationApiDTO, int reservationInfoId);

    void requestInfoAndPrices(ReservationApiDTO reservationApiDTO);

//    List<ReservationPrice> getReservationPrice(int reservationInfoId);
//
//    ReservationApiDTO getReservationInfo(int userID);

    ReservationApiDTO responseReservation(int userID, int reservationInfoId );
}
