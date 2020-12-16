package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.CommentDTO;
import kr.or.connect.reservation.dto.ProductsDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
public class ProductsApiDTO {
    public static final Integer START = 0;
    private int totalCount; //해당 카테고리의 전시 상품 수
    private int productCount; //읽어온 전시 상품 수
    private List<ProductsDTO> products;

    public void setProducts(List<ProductsDTO> products) {
        this.products = products;
        this.productCount = products.size();
    }


}
