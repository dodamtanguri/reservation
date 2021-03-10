package kr.or.connect.reservation.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Body.ReservationBody;
import kr.or.connect.reservation.dto.Body.ReservationPriceBody;
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
        reservationInfo.setReservationDate(req.getReservationYearMonthDay());
        reservationInfo.setProductId(req.getProductId());
        reservationInfo.setDisplayInfoId(req.getDisplayInfoId());
        reservationSerivce.insertReservationInfo(reservationInfo);

        int reservationId = reservationSerivce.selectReservationInfoId(reservationInfo);

        ReservationPrice reservationPrice = new ReservationPrice();
        reservationPrice.setCount(req.getPrices().get(0).getCount());
        reservationPrice.setProductPriceId(req.getPrices().get(0).getProductPriceId());
        reservationSerivce.insertPrices(reservationPrice,reservationId);


        return reservationSerivce.responseReservation(reservationInfo, reservationId);

    }
}
