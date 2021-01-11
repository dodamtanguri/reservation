package kr.or.connect.reservation.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.api.CategoriesApiDto;
import kr.or.connect.reservation.service.CategoriesService;
import kr.or.connect.reservation.service.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"카테고리 API"})
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class CategoryApiController {

    private final CategoriesService categoriesService;

    @ApiOperation(value = "카테고리 목록 구하기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
    @GetMapping("/categories")
    public CategoriesApiDto categoriesApiDto() {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return categoriesService.getCategories();
    }

}