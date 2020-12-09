package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.CategoriesDTO;

import java.util.List;

public class CategoriesApiDto {
    private int size;
    private List<CategoriesDTO> items;


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<CategoriesDTO> getItems() {
        return items;
    }

    public void setItems(List<CategoriesDTO> items) {
        this.size = items.size();
        this.items = items;
    }

    @Override
    public String toString() {
        return "CategoriesApiDto{" +
                "size=" + size +
                ", items=" + items +
                '}';
    }
}
