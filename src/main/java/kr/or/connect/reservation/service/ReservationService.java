package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.ReservationBody;
import kr.or.connect.reservation.dto.ReservationDTO;
import kr.or.connect.reservation.dto.ReservationPriceBody;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import kr.or.connect.reservation.dto.reservationInfoDTO;
import kr.or.connect.reservation.service.security.UserDbService;

public interface ReservationService extends UserDbService {
    void insertInfo (ReservationBody body);
    void insertPrice (ReservationPriceBody priceBody);

    ReservationApiDTO getReservationInfo (ReservationDTO dto);

}
