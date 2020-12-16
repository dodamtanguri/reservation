package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PromotionDTO {
    private int id;
    private int productId;
    private int categoryId;
    private String categoryName;
    private String productDescription;
    private int fileId;

}
