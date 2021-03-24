package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.ReservationDAO;
import kr.or.connect.reservation.dto.ReservationInfos;
import kr.or.connect.reservation.dto.api.GetReservationInfoApiDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@WebAppConfiguration
@WithMockUser(username = "carami@connect.co.kr", password = "1234", roles = {"ROLE_USER"})
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


}