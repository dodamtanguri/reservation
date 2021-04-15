package kr.or.connect.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationInfos {
    private int id;
    private int productId;
    private int displayInfoId;
    private int cancelFlag;
    private String productDescription;
    private String productContent;
    private int userId;
    private int sumPrice;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private LocalDate reservationDate;
    private LocalDateTime createDate =  LocalDateTime.now();
    private LocalDateTime modifyDate;
}
