package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.ReservationBody;
import kr.or.connect.reservation.dto.api.reservationApiDTO;
import kr.or.connect.reservation.dto.reservationInfoDTO;
import kr.or.connect.reservation.dto.reservationPriceDto;

public interface reservationService {
    reservationApiDTO getResInfo(ReservationBody reservationBody);
    reservationPriceDto getPrice(reservationPriceDto reservationPriceDto);
}
