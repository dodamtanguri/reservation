package kr.or.connect.reservation.dto.Body;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReservationBody {
    private List<ReservationPriceBody> prices;
    private int productId;
    private int displayInfoId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd", timezone = "Asia/Seoul")
    private Date reservationYearMonthDay;
    private int userId;


}
