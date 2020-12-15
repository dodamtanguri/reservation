package kr.or.connect.reservation.service;


import kr.or.connect.reservation.dto.api.ProductsApiDTO;

public interface ProductsService {
    public static final Integer START = 0;

    public ProductsApiDTO getProducts(int categoryId);



}
