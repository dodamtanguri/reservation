package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.ReservationDAO;
import kr.or.connect.reservation.dto.Body.CancelBody;
import kr.or.connect.reservation.dto.ReservationInfos;
import kr.or.connect.reservation.dto.api.GetReservationInfoApiDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;


@WebAppConfiguration
@WithMockUser(username = "carami@connect.co.kr", password = "1234", roles = {"ROLE_USER"})
public class ReservationServiceImplTest {


    @InjectMocks
    public ReservationServiceImpl reservationService;
    @Mock
    public ReservationDAO reservationDAO;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    //예약 등록 하기
//    @Test
//    @DisplayName("예약 등록 하기 - ReservationInfos")
//    public void testInsertReservation() throws Exception {
//
//        //given
//        ReservationPriceBody reqPrice = new ReservationPriceBody();
//        reqPrice.setCount(2);
//        reqPrice.setProductPriceId(3);
//
//        List<ReservationPriceBody> reqPriceList = new ArrayList<>();
//        reqPriceList.add(reqPrice);
//
//        ReservationBody req = new ReservationBody();
//        req.setProductId(1);
//        req.setPrices(reqPriceList);
//        req.setUserId(1);
//        req.setDisplayInfoId(1);
//        req.setReservationYearMonthDay(new Date());
//
//        ReservationApiDTO apiDTO = new ReservationApiDTO();
//        ReservationPrice apiPrice = new ReservationPrice();
//
//        when(reservationDAO.insertReservationInfo(apiDTO)).thenReturn(1);
//        when(reservationDAO.insertReservationPrice(apiPrice)).thenReturn(1);
//
//
//        //When
//        int insertActual = 1;
//        int insertInfoResult = reservationDAO.insertReservationInfo(apiDTO);
//        int insertPriceResult = reservationDAO.insertReservationPrice(apiPrice);
//        System.out.println("insertInfoResult: " + insertInfoResult + "insertPriceResult: " + insertPriceResult);
//        //then
//        assertEquals(insertActual, insertInfoResult);
//        assertEquals(insertActual, insertPriceResult);
//
//
//        //vertify
//        verify(reservationDAO, times(1)).insertReservationInfo(apiDTO);
//
//    }

    // 예약조회하기
    @Test
    @DisplayName("예약 조회 하기 ")
    public void testGetReservation() throws Exception {

        //given
        ReservationInfos reservationInfos = new ReservationInfos();
        reservationInfos.setId(51);
        reservationInfos.setProductId(1);
        reservationInfos.setDisplayInfoId(1);
        reservationInfos.setCancelFlag(1);
        reservationInfos.setProductDescription("PRODUCT DESCRIPTION");
        reservationInfos.setProductContent("PRODUCT CONTENT");
        reservationInfos.setUserId(1);
        reservationInfos.setSumPrice(11000);
        reservationInfos.setReservationDate(new Date(20200102));
        reservationInfos.setCreateDate(new Date());
        reservationInfos.setModifyDate(new Date());


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