package kr.or.connect.reservation.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.api.PromotionApiDto;
import kr.or.connect.reservation.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"프로모션 API"})
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class PromotionApiController {

    private final PromotionService promotionService;

    @ApiOperation(value = "프로모션 목록 구하기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
    @GetMapping(value = "/promotions")
    public PromotionApiDto promotionApiDto() {
        return promotionService.getPromotions();
    }
}
