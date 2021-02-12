package kr.or.connect.reservation.dto.Body;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReservationBody {
    private List<ReservationPriceBody> prices;

    private int productId;
    private int displayInfoId;
    private int reservationYearMonthDay;
    private int userId;
}
