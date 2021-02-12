package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class reservationPriceDto {
    private int id;
    private int reservationInfoId;
    private int productPriceId;
    private int count;
}
