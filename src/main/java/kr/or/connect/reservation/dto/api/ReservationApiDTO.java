package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.ReservationPrice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReservationApiDTO {
    private int id;
    private int productId;
    private int displayInfoId;
    private int userId;
    private LocalDate reservationDate;
    private int cancelFlag;
    private LocalDate createDate = LocalDate.now();
    private LocalDate modifyDate = LocalDate.now();
    private List<ReservationPrice> prices;

    public ReservationApiDTO(int id, int productId, int userId, int displayInfoId, LocalDate reservationDate, int cancelFlag, LocalDate createDate, LocalDate modifyDate) {
        this.id = id;
        this.productId = productId;
        this.displayInfoId = displayInfoId;
        this.userId = userId;
        this.reservationDate = reservationDate;
        this.cancelFlag = cancelFlag;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }
}