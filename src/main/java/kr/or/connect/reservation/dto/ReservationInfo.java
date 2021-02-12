package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
public class ReservationInfo {
    private int id;
    private int productId;
    private int displayInfoId;
    private int userId;
    private LocalDate reservationDate;
    private int cancelFlag;
    private LocalDate createDate = LocalDate.now();
    private LocalDate modifyDate = LocalDate.now();



    public void setreservationDate(Timestamp reservationDate) {
        this.reservationDate = reservationDate != null ? reservationDate.toLocalDateTime().toLocalDate() : null;
    }

}
