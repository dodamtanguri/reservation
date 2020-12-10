package kr.or.connect.reservation.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.api.DisplayinfosApiDto;
import kr.or.connect.reservation.service.DisplayinfosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = {"상품목록 API"})
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class DisplayinfosApiController {
    private final DisplayinfosService displayinfosService;

    @ApiOperation(value = "상품 목록 구하기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
    @RequestMapping(value = "/displayinfos", method = RequestMethod.GET)
    public DisplayinfosApiDto displayinfosDto(
            @RequestParam(name = "START", required = false, defaultValue = "0") int start,
            @RequestParam(name = "categoryId", required = false, defaultValue = "1") int categoryId) {
        return displayinfosService.getDisplayInfos(categoryId);
    }
}
