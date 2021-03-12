package kr.or.connect.reservation.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Body.CancelBody;
import kr.or.connect.reservation.dto.Body.ReservationBody;
import kr.or.connect.reservation.dto.CancelReservation;
import kr.or.connect.reservation.dto.ReservationPrice;
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
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),

    })
    @PostMapping(value = "/reservationInfos")
    public ReservationApiDTO reservation(@RequestBody ReservationBody req) {
        ReservationApiDTO reservationInfo = new ReservationApiDTO();
        reservationInfo.setReservationDate(req.getReservationYearMonthDay());
        reservationInfo.setProductId(req.getProductId());
        reservationInfo.setDisplayInfoId(req.getDisplayInfoId());
        reservationService.insertReservationInfo(reservationInfo);

        int reservationId = reservationService.selectReservationInfoId(reservationInfo);

        ReservationPrice reservationPrice = new ReservationPrice();
        reservationPrice.setCount(req.getPrices().get(0).getCount());
        reservationPrice.setProductPriceId(req.getPrices().get(0).getProductPriceId());
        reservationService.insertPrices(reservationPrice, reservationId);


        return reservationService.responseReservation(reservationInfo, reservationId);

    }

    @ApiOperation(value = "예약 조회 하기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),

    })
    @GetMapping(value = "/reservationInfos")
    public GetReservationInfoApiDTO getReservation() {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userID = customUserDetails.getUserId();
        return reservationService.getReservation(userID);
    }

    @ApiOperation(value = "예약 취소 하기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),

    })
    @PutMapping(value = "/reservationInfos")
    public CancelReservation cancelReservation(@RequestBody CancelBody req) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userID = customUserDetails.getUserId();
        int status = reservationService.cancelReservation(req.getId(), userID);
        CancelReservation cancelReservation = new CancelReservation();
        if (status == 0) {
            cancelReservation.setResult("fail");
        } else {
            cancelReservation.setResult("Success");
        }

        return cancelReservation;
    }
}
