package kr.or.connect.reservation.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.or.connect.reservation.dto.Body.ReservationBody;
import kr.or.connect.reservation.dto.Body.ReservationPriceBody;
import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.service.security.CustomUserDetails;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebAppConfiguration
@WithMockUser(username = "carami@connect.co.kr", password = "1234", roles = {"ROLE_USER"})
public class ReservationApiControllerTest {

    @Autowired
    private AuthenticationConfi


    @InjectMocks
    public ReservationApiController controller;

    @Mock
    ReservationService service;
    private MockMvc mockMvc;



    @Before
    public void createController() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .setCustomArgumentResolvers(new AuthenticationPrincipalArgumentResolver())
                .addFilters(new CharacterEncodingFilter("UTF-8",true)).build();
    }
    @Test
    @DisplayName("예약 등록 하기 ")
    public void postReservation() throws Exception {


        ReservationPriceBody reqPrice = new ReservationPriceBody();
        reqPrice.setCount(2);
        reqPrice.setProductPriceId(3);

        List<ReservationPriceBody> reqPriceList = new ArrayList<>();
        reqPriceList.add(reqPrice);

        ReservationBody body = new ReservationBody();
        body.setProductId(1);
        body.setDisplayInfoId(1);
        body.setUserId(1);
        body.setPrices(reqPriceList);
        body.setReservationYearMonthDay(new Date());

        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.setUsername("carami@connect.co.kr");
        userDetails.setPassword("1234");
        userDetails.setUserId(1);



        mockMvc.perform(
                        MockMvcRequestBuilders
                        .post("/api/reservationInfos")
                                .with(user(userDetails))
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(body))
                        .contentType(MediaType.APPLICATION_JSON)
        ).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(body)));

        //given




    }

    @Test
    @DisplayName("예약 조회 하기")
    public void getReservation() throws Exception {

    }

    @Test
    @DisplayName("예약 취소 하기")
    public void deleteReservation() throws Exception {

    }
}