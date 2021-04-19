package kr.or.connect.reservation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationPrice {
    private int id;
    private int reservationInfoId;
    private int productPriceId;
    private int count;

    @Builder
    public ReservationPrice(int id, int reservationInfoId, int productPriceId, int count) {
        this.id = id;
        this.reservationInfoId = reservationInfoId;
        this.productPriceId = productPriceId;
        this.count = count;
    }
}
