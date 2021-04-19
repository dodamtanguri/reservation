package kr.or.connect.reservation.dto.Body;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReservationPriceBody {
    private int count;
    private int productPriceId;

    @Builder
    public ReservationPriceBody(int count, int productPriceId) {
        this.count = count;
        this.productPriceId = productPriceId;
    }
}
