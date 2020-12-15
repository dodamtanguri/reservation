package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.CommentDTO;
import kr.or.connect.reservation.dto.ProductsDTO;

import java.util.List;

public class ProductsApiDTO {
    public static final Integer START = 0;
    private int totalCount; //해당 카테고리의 전시 상품 수
    private int productCount; //읽어온 전시 상품 수
    private List<ProductsDTO> products;

    private int commentTotalCount;
    private int commentCount;
    private List<CommentDTO> reservationUserComments;


    public List<ProductsDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsDTO> products) {
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

    public int getCommentTotalCount() {
        return commentTotalCount;
    }

    public void setCommentTotalCount(int commentTotalCount) {
        this.commentTotalCount = commentTotalCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public List<CommentDTO> getReservationUserComments() {
        return reservationUserComments;
    }

    public void setReservationUserComments(List<CommentDTO> reservationUserComments) {
        this.reservationUserComments = reservationUserComments;
    }

    @Override
    public String toString() {
        return "ProductsApiDTO{" +
                "totalCount=" + totalCount +
                ", productCount=" + productCount +
                ", products=" + products +
                ", commentTotalCount=" + commentTotalCount +
                ", commentCount=" + commentCount +
                ", reservationUserComments=" + reservationUserComments +
                '}';
    }
}
