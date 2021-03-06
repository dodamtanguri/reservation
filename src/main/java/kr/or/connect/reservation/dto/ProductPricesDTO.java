package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductPricesDTO {
    private int productPriceId;
    private int productId;
    private String priceTypeName;
    private int price;
    private int discountRate;
    private String createDate;
    private String modifyDate;
}
