package kr.or.connect.reservation.dto;

import kr.or.connect.reservation.dto.Body.ReservationPriceBody;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationPrice {
    private int id;
    private int reservationInfoId;
    private int productPriceId;
    private int count;


}
