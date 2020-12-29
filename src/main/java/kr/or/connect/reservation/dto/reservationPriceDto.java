package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class reservationPriceDto {
    private int id;
    private int reservationId;
    private int productPriceId;
    private int count;


}
