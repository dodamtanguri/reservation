package kr.or.connect.reservation.dto.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.or.connect.reservation.dto.ReservationPrice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonFormat
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


}
