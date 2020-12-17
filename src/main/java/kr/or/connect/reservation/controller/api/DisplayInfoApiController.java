package kr.or.connect.reservation.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.api.DisplayInfosApiDTO;
import kr.or.connect.reservation.service.DisplayInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"전시정보 API"})
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class DisplayInfoApiController {
    private final DisplayInfoService displayInfoService;

    @ApiOperation(value = "카테고리 목록 구하기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
    @GetMapping(value = "/displayinfos/{displayInfoId}")
    public DisplayInfosApiDTO displayInfosApiDTO(
            @PathVariable(name = "displayInfoId") int displayInfoId) {
        return displayInfoService.getDisplayInfos(displayInfoId);
    }


}
