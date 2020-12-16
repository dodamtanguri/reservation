package kr.or.connect.reservation.service.impl;


import kr.or.connect.reservation.dao.ProductsDAO;
import kr.or.connect.reservation.dto.api.ProductsApiDTO;
import kr.or.connect.reservation.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private final ProductsDAO productsDAO;


    @Override
    @Transactional(readOnly = true)
    public ProductsApiDTO getProducts(int categoryId, int start) {
        ProductsApiDTO productsApiDTO = new ProductsApiDTO();
        productsApiDTO.setProducts(productsDAO.getProducts(categoryId, start));
        productsApiDTO.setTotalCount(productsDAO.getTotalCount(categoryId));
        return productsApiDTO;
    }


}
