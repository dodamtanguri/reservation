package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.ReservationPriceBody;
import kr.or.connect.reservation.dto.reservationInfoDTO;
import kr.or.connect.reservation.dto.reservationPriceDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class reservationApiDTO {
    private List<ReservationPriceBody> prices;
    private int productId;
    private int displayInfoId;
    private int reservationYearMonthDay;
    private int userId;

}
