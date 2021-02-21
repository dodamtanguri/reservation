package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.CategoriesDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoriesApiDTO {
    private int size;
    private List<CategoriesDTO> items;

    public void setItems(List<CategoriesDTO> items) {
        this.size = items.size();
        this.items = items;
    }


}
