package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductsDTO {

    private int productId;
    private int categoryId;
    private int displayInfoId;
    private String categoryName;
    private String productDescription;
    private String productContent;
    private String productEvent;
    private String openingHours;
    private String placeName;
    private String placeLot;
    private String placeStreet;
    private String tel;
    private String homepage;
    private String email;
    private String createDate;
    private String modifyDate;
    private int fileId;

}
