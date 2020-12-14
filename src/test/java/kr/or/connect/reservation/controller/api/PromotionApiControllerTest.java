package kr.or.connect.reservation.controller.api;

import kr.or.connect.reservation.dto.PromotionDTO;
import kr.or.connect.reservation.dto.api.PromotionApiDto;
import kr.or.connect.reservation.service.PromotionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
public class PromotionApiControllerTest {
    @InjectMocks
    public PromotionApiController promotionApiController;
    @Mock
    PromotionService promotionService;
    private MockMvc mockMvc;
    @Before
    public void createController() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(promotionApiController).addFilters(new CharacterEncodingFilter("UTF-8", true)).build();
    }
    @Test
    public void getPromotion() throws Exception {
        PromotionDTO promotionDto = new PromotionDTO();
        promotionDto.setId(1010);
        promotionDto.setProductId(2020);
        promotionDto.setCategoryId(3030);
        promotionDto.setCategoryName("도담");
        promotionDto.setProductDescription("Promotion Controller Test");
        promotionDto.setFileId(4040);
        List<PromotionDTO> promotionDtoList = Arrays.asList(promotionDto);
        PromotionApiDto promotionApiDto = new PromotionApiDto();
        promotionApiDto.setItems(promotionDtoList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/promotions").contentType(MediaType.APPLICATION_JSON);
        when(promotionService.getPromotions()).thenReturn(promotionApiDto);

        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
        verify(promotionService).getPromotions();
    }


}