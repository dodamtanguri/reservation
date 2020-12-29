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
    private int displayinfoId;
    private int userId;
    private LocalDate reservationDate;
    private int cancelFlag;
    private LocalDate createDate;
    private LocalDate modifyDate;


    public void setreservationDate(Timestamp reservationDate) {
        this.reservationDate = reservationDate != null ? reservationDate.toLocalDateTime().toLocalDate() : null;
    }

    public void setcreateDate(Timestamp createDate) {
        this.createDate = createDate != null ? createDate.toLocalDateTime().toLocalDate() : null;
    }

    public void setmodifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate != null ? modifyDate.toLocalDateTime().toLocalDate() : null;
    }
}
