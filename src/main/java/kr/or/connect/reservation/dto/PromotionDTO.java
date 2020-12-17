package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class PromotionDTO {
    private int id;
    private int productId;
    private int categoryId;
    private String categoryName;
    private String productDescription;
    private int fileId;
}
