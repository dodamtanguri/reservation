package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.reservationPriceDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class reservationApiDTO {
    private int id;
    private int productId;
    private int cancelFlag;
    private int displayInfoId;
    private int userId;
    private LocalDate reservationDate;
    private LocalDate createDate;
    private LocalDate modifyDate;
    private List<reservationPriceDto> prices;

}
