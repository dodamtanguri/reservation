package kr.or.connect.reservation.service;


import kr.or.connect.reservation.dto.Body.CancelBody;
import kr.or.connect.reservation.dto.Body.ReservationBody;
import kr.or.connect.reservation.dto.CancelReservation;
import kr.or.connect.reservation.dto.api.GetReservationInfoApiDTO;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;


public interface ReservationService {
    ReservationApiDTO insertReservationInfo(ReservationBody req);

    GetReservationInfoApiDTO getReservation();

    CancelReservation cancelReservation(CancelBody req);
}
