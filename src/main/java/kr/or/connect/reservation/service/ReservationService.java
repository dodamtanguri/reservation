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

    ReservationInfo selectReservationInfo(ReservationInfo reservationInfo);

    ReservationPrice insertPrices(ReservationInfo reservationInfo);


    ReservationApiDTO responseReservation(ReservationInfo reservationInfo);
}
