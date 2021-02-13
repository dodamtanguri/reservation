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

    void requestInfoAndPrices(ReservationApiDTO reservationApiDTO);

    void requestPrices(ReservationApiDTO reservationApiDTO, int reservationInfoId);

    List<ReservationPrice> getReservationPrice(int reservationInfoId);

    ReservationApiDTO getReservationInfo(int reservationInfoId);

    ReservationApiDTO responseReservation(int reservationInfoId, int userId );
}
