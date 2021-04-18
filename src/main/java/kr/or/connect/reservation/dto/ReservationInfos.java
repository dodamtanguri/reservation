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
public class ReservationInfos {
    private int id;
    private int productId;
    private int displayInfoId;
    private int cancelFlag;
    private String productDescription;
    private String productContent;
    private int userId;
    private int sumPrice;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDate reservationDate;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDateTime createDate;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDateTime modifyDate;

    @Builder
    public ReservationInfos(int id, int productId, int displayInfoId, int cancelFlag, String productDescription, String productContent, int userId, int sumPrice, LocalDate reservationDate, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.id = id;
        this.productId = productId;
        this.displayInfoId = displayInfoId;
        this.cancelFlag = cancelFlag;
        this.productDescription = productDescription;
        this.productContent = productContent;
        this.userId = userId;
        this.sumPrice = sumPrice;
        this.reservationDate = reservationDate;
        this.createDate = LocalDateTime.now();
        this.modifyDate = LocalDateTime.now();
    }
}
