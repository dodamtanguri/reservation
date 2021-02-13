package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.ReservationPrice;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
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

    public ReservationApiDTO(int id, int productId, int displayInfoId, int userId, LocalDate reservationDate, int cancelFlag, LocalDate createDate, LocalDate modifyDate) {
        this.id = id;
        this.productId = productId;
        this.displayInfoId = displayInfoId;
        this.userId = userId;
        this.reservationDate = reservationDate;
        this.cancelFlag = cancelFlag;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public void setreservationDate(Timestamp reservationDate) {
        this.reservationDate = reservationDate != null ? reservationDate.toLocalDateTime().toLocalDate() : null;
    }


}
