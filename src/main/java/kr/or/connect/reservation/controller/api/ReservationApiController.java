package kr.or.connect.reservation.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Body.ReservationBody;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.service.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = {"예약등록 API"})
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ReservationApiController {

    private final ReservationService reservationSerivce;

    @ApiOperation(value = "예약 등록 하기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),

    })
    @PostMapping(value = "/reservationInfos")
    public ReservationApiDTO reservation(@RequestBody ReservationBody req) {
        ReservationInfo reservationInfo = new ReservationInfo();

        int reservationInfoId = reservationInfo.getId();
        int userID = reservationInfo.getUserId();

        reservationSerivce.requestReservationInfo(reservationInfo);
        reservationSerivce.requestPrices(reservationInfoId);

        return reservationSerivce.responseReservation(userID, reservationInfoId);

    }
}