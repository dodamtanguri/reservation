package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.PromotionDto;

import java.util.List;

public class PromotionApiDto {
    private int size;
    private List<PromotionDto> items;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<PromotionDto> getItems() {
        return items;
    }

    public void setItems(List<PromotionDto> items) {
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
