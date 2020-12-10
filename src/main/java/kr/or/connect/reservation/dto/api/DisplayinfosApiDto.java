package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.DisplayinfosDTO;

import java.util.List;

public class DisplayinfosApiDto {
    public static final Integer START = 0;
    private int totalCount; //해당 카테고리의 전시 상품 수
    private int productCount; //읽어온 전시 상품 수
    private List<DisplayinfosDTO> products;


    public List<DisplayinfosDTO> getProducts() {
        return products;
    }

    public void setProducts(List<DisplayinfosDTO> products) {
        this.products = products;
        this.productCount = products.size();
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return "DisplayinfosApiDto{" +
                "totalCount=" + totalCount +
                ", productCount=" + productCount +
                ", products=" + products +
                '}';
    }
}
