package kr.or.connect.reservation.controller.api;

import kr.or.connect.reservation.dto.DisplayinfosDTO;
import kr.or.connect.reservation.dto.api.DisplayinfosApiDto;
import kr.or.connect.reservation.service.DisplayinfosService;
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

import static org.mockito.Mockito.when;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
public class DisplayinfosApiControllerTest {
    @InjectMocks
    public DisplayinfosApiController displayinfosApiController;
    @Mock
    DisplayinfosService displayinfosService;
    private MockMvc mockMvc;

    @Before
    public void createController() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(displayinfosApiController).addFilters(new CharacterEncodingFilter("UTF-8", true)).build();
    }
    //total Product
    @Test
    public void getTotalCount() throws Exception {
        DisplayinfosDTO displayinfosDTO = new DisplayinfosDTO();
        displayinfosDTO.setProductId(1010);
        displayinfosDTO.setCategoryId(1);
        displayinfosDTO.setDisplayInfoId(1010);
        displayinfosDTO.setCategoryName("카테고리 이름");
        displayinfosDTO.setProductDescription("상품설명");
        displayinfosDTO.setProductContent("상품내용");
        displayinfosDTO.setProductEvent("상품 이벤트");
        displayinfosDTO.setOpeningHours("시작 시간");
        displayinfosDTO.setPlaceName("공연장소");
        displayinfosDTO.setPlaceLot("지번 주소");
        displayinfosDTO.setPlaceStreet("도로명 주소");
        displayinfosDTO.setTel("문의전화번호");
        displayinfosDTO.setHomepage("홈페이지");
        displayinfosDTO.setEmail("문의 이메일");
        displayinfosDTO.setCreateDate("생성시간");
        displayinfosDTO.setModifyDate("수정시간");
        displayinfosDTO.setFileId(2020);
        List<DisplayinfosDTO> displayinfosDTOList = Arrays.asList(displayinfosDTO);
        DisplayinfosApiDto displayinfosApiDto = new DisplayinfosApiDto();
        displayinfosApiDto.setProducts(displayinfosDTOList);
        displayinfosApiDto.setTotalCount(1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/displayinfos").contentType(MediaType.APPLICATION_JSON);
        when(displayinfosService.getDisplayInfos(1)).thenReturn(displayinfosApiDto);

        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
        verify(displayinfosService).getDisplayInfos(1);

    }
}