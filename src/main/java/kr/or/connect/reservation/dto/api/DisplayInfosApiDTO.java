package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.*;

import java.util.List;

public class DisplayInfosApiDTO {
    private List<DisplayInfosDTO> product;
    private List<ProductImagesDTO> productImage;
    private List<DisplayInfosImageDTO> displayImage;
    private int avgScore;
    private List<ProductPricesDTO> productPrices;

    public List<DisplayInfosDTO> getProduct() {
        return product;
    }

    public void setProduct(List<DisplayInfosDTO> product) {
        this.product = product;
    }

    public List<ProductImagesDTO> getProductImage() {
        return productImage;
    }

    public void setProductImage(List<ProductImagesDTO> productImage) {
        this.productImage = productImage;
    }

    public List<DisplayInfosImageDTO> getDisplayImage() {
        return displayImage;
    }

    public void setDisplayImage(List<DisplayInfosImageDTO> displayImage) {
        this.displayImage = displayImage;
    }

    public int getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(int avgScore) {
        this.avgScore = avgScore;
    }

    public List<ProductPricesDTO> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<ProductPricesDTO> productPrices) {
        this.productPrices = productPrices;
    }

    @Override
    public String toString() {
        return "DisplayInfosApiDTO{" +
                "product=" + product +
                ", productImage=" + productImage +
                ", displayImage=" + displayImage +
                ", avgScore=" + avgScore +
                ", productPrices=" + productPrices +
                '}';
    }
}
