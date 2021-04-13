package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.ReservationDAO;
import kr.or.connect.reservation.dto.Body.CancelBody;
import kr.or.connect.reservation.dto.Body.ReservationBody;
import kr.or.connect.reservation.dto.CancelReservation;
import kr.or.connect.reservation.dto.InsertReservationInfo;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.api.GetReservationInfoApiDTO;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import kr.or.connect.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDAO dao;

    @Override
    public ReservationApiDTO insertReservationInfo(ReservationBody reservation, int userID) {

        InsertReservationInfo info = new InsertReservationInfo();
        info.setUserId(userID);
        info.setProductId(reservation.getProductId());
        info.setDisplayInfoId(reservation.getDisplayInfoId());
        info.setReservationDate(reservation.getReservationYearMonthDay());

        int reservationInfoId = dao.insertReservationInfo(info);

        List<ReservationPrice> priceList = new ArrayList<>();
        for (int i = 0; i < reservation.getPrices().size(); i++) {
            ReservationPrice priceDTO = new ReservationPrice();
            priceDTO.setReservationInfoId(reservationInfoId);
            priceDTO.setCount(reservation.getPrices().get(i).getCount());
            priceDTO.setProductPriceId(reservation.getPrices().get(i).getProductPriceId());
            priceList.add(priceDTO);
        }
        int[] status = dao.insertReservationPriceInfo(priceList);
        ReservationApiDTO apiDTO = new ReservationApiDTO(info, priceList);
        apiDTO.setId(reservationInfoId);
        int limit = reservation.getPrices().size();
        List<Map<String, Object>> prices = dao.getReservationPriceInfo(reservationInfoId, limit);
        List<Integer> priceList2 = new ArrayList<Integer>();
        for(Map<String,Object> data : prices) {
            priceList2.add(data.get("id"))  ;
        }
        for (int i = 0; i < limit; i++) {
                apiDTO.getPrices().get(i).setId(prices.);
        }
        return apiDTO;
    }

    @Override
    public GetReservationInfoApiDTO getReservation(int userID) {
        GetReservationInfoApiDTO apiDTO = new GetReservationInfoApiDTO();
        apiDTO.setItems(dao.getReservationInfoApiDTO(userID));
        return apiDTO;
    }

    @Override
    public CancelReservation cancelReservation(CancelBody req, int userID) {
        int status = dao.cancelReservation(req.getId(), userID);
        CancelReservation cancelReservation = new CancelReservation();
        cancelReservation.setResult(status == 0 ? "fail" : "Success");

        return cancelReservation;
    }
}