package kr.or.connect.reservation.service;


import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.api.GetReservationInfoApiDTO;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;


public interface ReservationService {
    void insertReservationInfo(ReservationApiDTO reservationInfo);

    int selectReservationInfoId(ReservationApiDTO reservationInfo);

    void insertPrices(ReservationPrice reservationPrice, int reservationId);

    ReservationApiDTO responseReservation(ReservationApiDTO reservationInfo, int reservationId);


    GetReservationInfoApiDTO getReservation(int userID);
}
