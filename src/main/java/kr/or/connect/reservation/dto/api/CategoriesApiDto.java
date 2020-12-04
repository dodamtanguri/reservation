package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.CategoriesDTO;

import java.util.List;

public class CategoriesApiDto {
    private List<CategoriesDTO> items;

    public List<CategoriesDTO> getItems() {
        return items;
    }

    public void setItems(List<CategoriesDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CategoriesApiDto{" +
                "items=" + items +
                '}';
    }
}
