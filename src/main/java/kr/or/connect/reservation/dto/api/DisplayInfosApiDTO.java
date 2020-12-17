package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter

public class DisplayInfosApiDTO {
    private List<DisplayInfosDTO> product;
    private List<ProductImagesDTO> productImage;
    private List<DisplayInfosImageDTO> displayImage;
    private int avgScore;
    private List<ProductPricesDTO> productPrices;

}
