package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.Body.ReservationBody;
import kr.or.connect.reservation.dto.Body.ReservationPriceBody;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import kr.or.connect.reservation.service.security.UserDbService;

import java.util.List;

public interface ReservationService {
    ReservationInfo insertReservationInfo(ReservationInfo reservationInfo);

    void insertPrices(  int reservationInfoId);

    ReservationApiDTO responseReservation(int userID, int reservationInfoId );
}
