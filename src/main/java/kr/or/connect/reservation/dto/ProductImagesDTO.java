package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class ProductImagesDTO {
    private int productId;
    private int productImageId;
    private String type;
    private int fileInfoId;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private int deleteFlag;
    private String createDate;
    private String modifyDate;


}
