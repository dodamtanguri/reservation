package kr.or.connect.reservation.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Body.ReservationBody;
import kr.or.connect.reservation.dto.UserDto;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import kr.or.connect.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Api(tags = {"예약등록 API"})
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class reservationApiController {

    private final ReservationService reservationSerivce;

    @ApiOperation(value = "예약 등록 하기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
    @PostMapping(value = "/reservationInfos")
    public ReservationApiDTO reservation(@RequestBody ReservationBody req) {
        int userId = user.getId();
        req.setUserId(userId);
        int reservationInfoId = reservationSerivce.getReservationInfo().getId();

        return reservationSerivce.responseReservation(reservationInfoId,userId);

    }
}
