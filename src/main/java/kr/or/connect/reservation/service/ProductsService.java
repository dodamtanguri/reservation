package kr.or.connect.reservation.service;



import kr.or.connect.reservation.dto.api.ProductsApiDTO;

public interface ProductsService {


     ProductsApiDTO getProducts(int categoryId, int start);


}
