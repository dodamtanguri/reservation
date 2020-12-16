package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.CategoriesDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CategoriesApiDto {
    private int size;
    private List<CategoriesDTO> items;

    public void setItems(List<CategoriesDTO> items) {
        this.size = items.size();
        this.items = items;
    }


}
