package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class reservationPriceDto {
    private int id;
    private int reservation_info_id;
    private int product_price_id;
    private int count;
}
