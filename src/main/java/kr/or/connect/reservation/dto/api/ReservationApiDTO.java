package kr.or.connect.reservation.dto.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.or.connect.reservation.dto.InsertReservationInfo;
import kr.or.connect.reservation.dto.ReservationPrice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReservationApiDTO {


    private int id;
    private int productId;
    private int displayInfoId;
    private int userId;
    private int cancelFlag;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private LocalDate reservationDate;
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime modifyDate = LocalDateTime.now();
    private List<ReservationPrice> prices;


    public ReservationApiDTO(InsertReservationInfo info, List<ReservationPrice> prices) {
        this.id = info.getId();
        this.productId = info.getProductId();
        this.displayInfoId = info.getDisplayInfoId();
        this.userId = info.getUserId();
        this.cancelFlag = info.getCancelFlag();
        this.reservationDate = info.getReservationDate();
        this.createDate = info.getCreateDate();
        this.modifyDate = info.getModifyDate();
        this.prices = prices;
    }


}