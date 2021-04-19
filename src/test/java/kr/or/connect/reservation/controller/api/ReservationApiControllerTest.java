package kr.or.connect.reservation.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.Body.CancelBody;
import kr.or.connect.reservation.dto.Body.ReservationBody;
import kr.or.connect.reservation.dto.Body.ReservationPriceBody;
import kr.or.connect.reservation.dto.CancelReservation;
import kr.or.connect.reservation.dto.ReservationInfos;
import kr.or.connect.reservation.dto.api.GetReservationInfoApiDTO;
import kr.or.connect.reservation.service.ReservationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@WebAppConfiguration
public class ReservationApiControllerTest {


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
                .addFilters(new CharacterEncodingFilter("UTF-8", true)).build();
    }

    @Test
    @WithMockCustomUser
    @DisplayName("예약 등록 하기 ")
    public void postReservation() throws Exception {
        ReservationPriceBody reqPrice = ReservationPriceBody.builder()
                .count(2)
                .productPriceId(3)
                .build();
        List<ReservationPriceBody> reqPriceList = new ArrayList<>();
        reqPriceList.add(reqPrice);

        ReservationBody body = new ReservationBody();
        body.setProductId(1);
        body.setDisplayInfoId(1);
        body.setUserId(1);
        body.setPrices(reqPriceList);
        body.setReservationYearMonthDay(LocalDate.of(2020, 10, 10));

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/reservationInfos")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(mapper.writeValueAsString(body))
                        .contentType(MediaType.APPLICATION_JSON)

        ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }


    @Test
    @WithMockCustomUser
    @DisplayName("예약 조회 하기")
    public void getReservation() throws Exception {

        ReservationInfos items = ReservationInfos.builder()
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

        List<ReservationInfos> itemList = Arrays.asList(items);
        GetReservationInfoApiDTO getReservation = new GetReservationInfoApiDTO();
        getReservation.setItems(itemList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/reservationInfos")
                .contentType(MediaType.APPLICATION_JSON);

        when(service.getReservation(items.getUserId())).thenReturn(getReservation);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk()).andDo(print());

        verify(service).getReservation(items.getUserId());


    }

    @Test
    @WithMockCustomUser
    @DisplayName("예약 취소 하기")
    public void cancelReservation() throws Exception {
        CancelBody cancelBody = new CancelBody();
        cancelBody.setId(51);
        CancelReservation cancelReservation = new CancelReservation();
        cancelReservation.setResult("Success");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/reservationInfos")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(new ObjectMapper().writeValueAsString(cancelBody));

        when(service.cancelReservation(cancelBody, 1)).thenReturn(cancelReservation);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(print());


    }
}