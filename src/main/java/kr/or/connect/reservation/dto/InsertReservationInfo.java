package kr.or.connect.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class InsertReservationInfo {
    private int id;
    private int productId;
    private int displayInfoId;
    private int userId;
    private int cancelFlag;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate reservationDate;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDateTime createDate = LocalDateTime.now();
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDateTime modifyDate = LocalDateTime.now();

    @Builder
    public InsertReservationInfo(int id, int productId, int displayInfoId, int userId, int cancelFlag, LocalDate reservationDate, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.id = id;
        this.productId = productId;
        this.displayInfoId = displayInfoId;
        this.userId = userId;
        this.cancelFlag = cancelFlag;
        this.reservationDate = reservationDate;
        this.createDate = LocalDateTime.now();
        this.modifyDate = LocalDateTime.now();
    }
}
