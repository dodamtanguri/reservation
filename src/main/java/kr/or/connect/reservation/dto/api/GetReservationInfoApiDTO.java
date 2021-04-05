package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.ReservationInfos;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class GetReservationInfoApiDTO {
    private int size;
    private List<ReservationInfos> items;

    public void setItems(List<ReservationInfos> items) {
        this.size = items.size();
        this.items = items;
    }

}
