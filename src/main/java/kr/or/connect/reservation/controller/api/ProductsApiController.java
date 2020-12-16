package kr.or.connect.reservation.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.api.ProductsApiDTO;
import kr.or.connect.reservation.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@Api(tags = {"상품 API"})
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ProductsApiController {
    private final ProductsService productsService;

    @ApiOperation(value = "상품 목록 구하기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
    @GetMapping(value = "/displayinfos")
    public ProductsApiDTO productsApiDTO(
            @RequestParam(name = "START", required = false, defaultValue = "0") int start,
            @RequestParam(name = "categoryId", required = false, defaultValue = "1") int categoryId) {
        return productsService.getProducts(categoryId,start);
    }

}
