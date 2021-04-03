package kr.or.connect.reservation.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Body.CancelBody;
import kr.or.connect.reservation.dto.Body.ReservationBody;
import kr.or.connect.reservation.dto.CancelReservation;
import kr.or.connect.reservation.dto.api.GetReservationInfoApiDTO;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.service.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@Api(tags = {"예약 API"})
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ReservationApiController {

    private final ReservationService reservationService;

    @ApiOperation(value = "예약 등록 하기")
    @ApiResponses({@ApiResponse(code = 200, message = "OK")})
    @PostMapping(value = "/reservationInfos")
    public ReservationApiDTO reservation(@RequestBody ReservationBody req) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userID = customUserDetails.getUserId();
        return reservationService.insertReservationInfo(req,userID);
    }

    @ApiOperation(value = "예약 조회 하기")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"),})
    @GetMapping(value = "/reservationInfos")
    public GetReservationInfoApiDTO getReservation() {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userID = customUserDetails.getUserId();
        return reservationService.getReservation(userID);
    }

    @ApiOperation(value = "예약 취소 하기")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"),})
    @PutMapping(value = "/reservationInfos")
    public CancelReservation cancelReservation(@RequestBody CancelBody req) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userID = customUserDetails.getUserId();
        return reservationService.cancelReservation(req,userID);
    }
}
