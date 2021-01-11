package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
public class reservationInfoDTO {
    private int id;
    private int productId;
    private int display_info_id;
    private int userId;
    private LocalDate reservationDate;
    private int cancelFlag;
    private LocalDate createDate = LocalDate.now();
    private LocalDate modifyDate;


    public void setreservationDate(Timestamp reservationDate) {
        this.reservationDate = reservationDate != null ? reservationDate.toLocalDateTime().toLocalDate() : null;
    }

    public void setmodifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate != null ? modifyDate.toLocalDateTime().toLocalDate() : null;
    }
}
