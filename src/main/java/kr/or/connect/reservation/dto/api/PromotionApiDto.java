package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.PromotionDTO;

import java.util.List;

public class PromotionApiDto {
    private int size;
    private List<PromotionDTO> items;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<PromotionDTO> getItems() {
        return items;
    }

    public void setItems(List<PromotionDTO> items) {
        this.size = items.size();
        this.items = items;
    }

    @Override
    public String toString() {
        return "PromotionApiDto{" +
                "size=" + size +
                ", items=" + items +
                '}';
    }
}
