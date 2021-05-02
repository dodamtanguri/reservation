package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.controller.api.WithMockCustomUser;
import kr.or.connect.reservation.dao.ReservationDAO;
import kr.or.connect.reservation.dto.Body.CancelBody;
import kr.or.connect.reservation.dto.Body.ReservationBody;
import kr.or.connect.reservation.dto.Body.ReservationPriceBody;
import kr.or.connect.reservation.dto.InsertReservationInfo;
import kr.or.connect.reservation.dto.ReservationInfos;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.api.GetReservationInfoApiDTO;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@WebAppConfiguration
@WithMockCustomUser
@Transactional
public class ReservationServiceImplTest {


    @InjectMocks
    public ReservationServiceImpl reservationService;


    @Mock
    public ReservationDAO reservationDAO;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void insertReservationInfo() throws Exception {
        ReservationPriceBody reqPrice = ReservationPriceBody.builder()
                .productPriceId(3)
                .count(3).build();

        List<ReservationPriceBody> reqPriceList = new ArrayList<>();
        reqPriceList.add(reqPrice);

        ReservationBody req = ReservationBody.builder()
                .productId(1)
                .prices(reqPriceList)
                .displayInfoId(1)
                .userId(1)
                .reservationYearMonthDay(LocalDate.now()).build();

        InsertReservationInfo info = InsertReservationInfo.builder()
                .reservationDate(req.getReservationYearMonthDay())
                .productId(req.getProductId())
                .displayInfoId(req.getDisplayInfoId())
                .userId(req.getUserId())
                .id(53)
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .cancelFlag(0)
                .build();

        List<ReservationPrice> prices = new ArrayList<>();
        ReservationPrice price = ReservationPrice.builder()
                .id(104)
                .productPriceId(reqPrice.getProductPriceId())
                .reservationInfoId(info.getId())
                .count(reqPrice.getCount())
                .build();
        prices.add(price);


        ReservationApiDTO actual = new ReservationApiDTO(info, prices);

        given(reservationDAO.insertReservationInfo(info)).willReturn(info.getId());
        given(reservationDAO.getReservationPriceInfo(info.getId(), prices.size())).willReturn(prices);


        ReservationApiDTO insertReservationInfo = reservationService.insertReservationInfo(req, 1);


        assertEquals(insertReservationInfo.getProductId(), info.getProductId());
        assertEquals(insertReservationInfo.getDisplayInfoId(), info.getDisplayInfoId());
        assertEquals(insertReservationInfo.getUserId(), info.getUserId());


    }


    // 예약조회하기
    @Test
    @DisplayName("예약 조회 하기 ")
    public void testGetReservation() throws Exception {
        //given
        ReservationInfos reservationInfos = ReservationInfos.builder()
                .id(51)
                .productId(1)
                .displayInfoId(1)
                .cancelFlag(1)
                .productDescription("PRODUCT DESCRIPTION")
                .productContent("PRODUCT CONTENT")
                .userId(1)
                .sumPrice(11000)
                .reservationDate(LocalDate.of(2020, 1, 2))
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now()).build();


        List<ReservationInfos> reservation = new ArrayList<>();
        reservation.add(reservationInfos);

        GetReservationInfoApiDTO actual = new GetReservationInfoApiDTO();
        actual.setItems(reservation);

        when(reservationDAO.getReservationInfoApiDTO(reservationInfos.getUserId())).thenReturn(reservation);

        GetReservationInfoApiDTO result = reservationService.getReservation(reservationInfos.getUserId());

        assertThat(actual, is(result));

        verify(reservationDAO, times(1)).getReservationInfoApiDTO(reservationInfos.getUserId());
    }

    //예약 취소 하기
    @Test
    @DisplayName("예약 취소 하기")
    public void testDeleteReservation() throws Exception {
        //given
        CancelBody cancel = new CancelBody();
        cancel.setId(53);

        when(reservationDAO.cancelReservation(cancel.getId(), 1)).thenReturn(1);

        //when
        int deleteActual = 1;
        int deleteResult = reservationDAO.cancelReservation(cancel.getId(), 1);
        //then
        assertEquals(deleteActual, deleteResult);

        verify(reservationDAO, times(1)).cancelReservation(cancel.getId(), 1);


    }


}