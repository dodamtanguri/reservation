package kr.or.connect.reservation.dto.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.or.connect.reservation.dto.ReservationPrice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
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
    private Date reservationDate;
    private Date createDate = new Date();
    private Date modifyDate = new Date();
    private List<ReservationPrice> prices;


}
