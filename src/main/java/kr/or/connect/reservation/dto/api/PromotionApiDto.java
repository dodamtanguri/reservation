package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.PromotionDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter

public class PromotionApiDto {
    private int size;
    private List<PromotionDTO> items;


    public void setItems(List<PromotionDTO> items) {
        this.size = items.size();
        this.items = items;
    }

}
