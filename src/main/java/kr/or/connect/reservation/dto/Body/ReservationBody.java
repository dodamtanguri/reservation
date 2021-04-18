package kr.or.connect.reservation.dto.Body;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReservationBody {
    private List<ReservationPriceBody> prices;
    private int productId;
    private int displayInfoId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate reservationYearMonthDay;
    private int userId;

    @Builder
    public ReservationBody(List<ReservationPriceBody> prices, int productId, int displayInfoId, LocalDate reservationYearMonthDay, int userId) {
        this.prices = prices;
        this.productId = productId;
        this.displayInfoId = displayInfoId;
        this.reservationYearMonthDay = reservationYearMonthDay;
        this.userId = userId;
    }
}
