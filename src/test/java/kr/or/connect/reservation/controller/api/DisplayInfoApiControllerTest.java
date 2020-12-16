package kr.or.connect.reservation.controller.api;

import kr.or.connect.reservation.dto.DisplayInfosDTO;
import kr.or.connect.reservation.dto.DisplayInfosImageDTO;
import kr.or.connect.reservation.dto.ProductImagesDTO;
import kr.or.connect.reservation.dto.ProductPricesDTO;
import kr.or.connect.reservation.dto.api.DisplayInfosApiDTO;
import kr.or.connect.reservation.service.DisplayInfoService;
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
public class DisplayInfoApiControllerTest {
    @InjectMocks
    public DisplayInfoApiController displayInfoApiController;
    @Mock
    DisplayInfoService displayInfoService;
    private MockMvc mockMvc;

    @Before
    public void createController() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(displayInfoApiController).addFilters(new CharacterEncodingFilter("UTF-8", true)).build();
    }

    @Test
    public void getDisplayInfo() throws Exception {
        DisplayInfosDTO dto = new DisplayInfosDTO();
        dto.setProductId(1010);
        dto.setCategoryId(2020);
        dto.setDisplayInfoId(1);
        dto.setCategoryName("TEST");
        dto.setProductDescription("테스트 코드 입니다.");
        dto.setProductContent("DISPLAYINFO CONTROLLER 테스트 중입니다.");
        dto.setProductEvent(" ");
        dto.setOpeningHours("2020.12.15 AM12:05");
        dto.setPlaceName("도담이네집");
        dto.setPlaceLot("도담이네집");
        dto.setPlaceStreet("도담로");
        dto.setTel("010-0000-0000");
        dto.setHomepage("dodam");
        dto.setEmail("dodam@naver.com");
        dto.setCreateDate("2020.12.15");
        dto.setModifyDate("2020.12.15");
        List<DisplayInfosDTO> displayList = Arrays.asList((dto));
        DisplayInfosApiDTO apiDTO = new DisplayInfosApiDTO();
        apiDTO.setProduct(displayList);


        RequestBuilder rb = MockMvcRequestBuilders.get("/api/displayinfos/{displayInfoId}", 1).contentType(MediaType.APPLICATION_JSON);
        when(displayInfoService.getDisplayInfos(1)).thenReturn(apiDTO);

        mockMvc.perform(rb).andExpect(status().isOk()).andDo(print());
        verify(displayInfoService).getDisplayInfos(1);
    }

    @Test
    public void getProductImage() throws Exception {
        ProductImagesDTO dto = new ProductImagesDTO();
        dto.setProductId(1010);
        dto.setProductImageId(10);
        dto.setType("ma");
        dto.setFileInfoId(3030);
        dto.setFileName("원본 파일명");
        dto.setSaveFileName("save파일 명");
        dto.setContentType("파일 mime type");
        dto.setDeleteFlag(0);
        dto.setCreateDate("등록일");
        dto.setModifyDate("수정일");
        List<ProductImagesDTO> productImagesDTOList = Arrays.asList(dto);
        DisplayInfosApiDTO apiDTO = new DisplayInfosApiDTO();
        apiDTO.setProductImage(productImagesDTOList);

        RequestBuilder rb = MockMvcRequestBuilders.get("/api/displayinfos/{displayInfoId}", 1).contentType(MediaType.APPLICATION_JSON);
        when(displayInfoService.getDisplayInfos(1)).thenReturn(apiDTO);

        mockMvc.perform(rb).andExpect(status().isOk()).andDo(print());
        verify(displayInfoService).getDisplayInfos(1);

    }

    @Test
    public void getDisplayImage() throws Exception {
        DisplayInfosImageDTO dto = new DisplayInfosImageDTO();
        dto.setDisplayInfoImageId(101010);
        dto.setDisplayInfoId(1);
        dto.setFileId(3030);
        dto.setFileName("원본 파일명");
        dto.setSaveFileName("save파일 명");
        dto.setContentType("파일 mime type");
        dto.setDeleteFlag(0);
        dto.setCreateDate("등록일");
        dto.setModifyDate("수정일");
        List<DisplayInfosImageDTO> displayInfosImageDTOList = Arrays.asList(dto);
        DisplayInfosApiDTO apiDTO = new DisplayInfosApiDTO();
        apiDTO.setDisplayImage(displayInfosImageDTOList);

        RequestBuilder rb = MockMvcRequestBuilders.get("/api/displayinfos/{displayInfoId}", 1).contentType(MediaType.APPLICATION_JSON);
        when(displayInfoService.getDisplayInfos(1)).thenReturn(apiDTO);

        mockMvc.perform(rb).andExpect(status().isOk()).andDo(print());
        verify(displayInfoService).getDisplayInfos(1);
    }

    @Test
    public void getAvgScore() throws Exception {
        DisplayInfosApiDTO apiDTO = new DisplayInfosApiDTO();
        apiDTO.setAvgScore(3);

        RequestBuilder rb = MockMvcRequestBuilders.get("/api/displayinfos/{displayInfoId}", 1).contentType(MediaType.APPLICATION_JSON);
        when(displayInfoService.getDisplayInfos(1)).thenReturn(apiDTO);

        mockMvc.perform(rb).andExpect(status().isOk()).andDo(print());
        verify(displayInfoService).getDisplayInfos(1);
    }

    @Test
    public void getProductPrice() throws Exception {
        ProductPricesDTO dto = new ProductPricesDTO();
        dto.setProductPriceId(4040);
        dto.setProductId(1010);
        dto.setPriceTypeName("가격 유형 이름");
        dto.setPrice(200000);
        dto.setDiscountRate(50);
        dto.setCreateDate("등록일");
        dto.setModifyDate("수정일");
        List<ProductPricesDTO> pricesDTOS = Arrays.asList(dto);
        DisplayInfosApiDTO apiDTO = new DisplayInfosApiDTO();
        apiDTO.setProductPrices(pricesDTOS);

        RequestBuilder rb = MockMvcRequestBuilders.get("/api/displayinfos/{displayInfoId}", 1).contentType(MediaType.APPLICATION_JSON);
        when(displayInfoService.getDisplayInfos(1)).thenReturn(apiDTO);

        mockMvc.perform(rb).andExpect(status().isOk()).andDo(print());
        verify(displayInfoService).getDisplayInfos(1);
    }
}