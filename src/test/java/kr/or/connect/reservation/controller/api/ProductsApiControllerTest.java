package kr.or.connect.reservation.controller.api;

import kr.or.connect.reservation.dto.ProductsDTO;
import kr.or.connect.reservation.dto.api.ProductsApiDTO;
import kr.or.connect.reservation.service.ProductsService;
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

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
public class ProductsApiControllerTest {
    @InjectMocks
    public ProductsApiController productsApiController;
    @Mock
    ProductsService productsService;
    private MockMvc mockMvc;

    @Before
    public void createController() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productsApiController).addFilters(new CharacterEncodingFilter("UTF-8", true)).build();
    }
    //total Product
    @Test
    public void getTotalCount() throws Exception {
        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setProductId(1010);
        productsDTO.setCategoryId(1);
        productsDTO.setDisplayInfoId(1010);
        productsDTO.setCategoryName("카테고리 이름");
        productsDTO.setProductDescription("상품설명");
        productsDTO.setProductContent("상품내용");
        productsDTO.setProductEvent("상품 이벤트");
        productsDTO.setOpeningHours("시작 시간");
        productsDTO.setPlaceName("공연장소");
        productsDTO.setPlaceLot("지번 주소");
        productsDTO.setPlaceStreet("도로명 주소");
        productsDTO.setTel("문의전화번호");
        productsDTO.setHomepage("홈페이지");
        productsDTO.setEmail("문의 이메일");
        productsDTO.setCreateDate("생성시간");
        productsDTO.setModifyDate("수정시간");
        productsDTO.setFileId(2020);
        List<ProductsDTO> displayinfosDTOList = Arrays.asList(productsDTO);
        ProductsApiDTO productsApiDTO = new ProductsApiDTO();
        productsApiDTO.setProducts(displayinfosDTOList);
        productsApiDTO.setTotalCount(1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/displayinfos").contentType(MediaType.APPLICATION_JSON);
        when(productsService.getProducts(1)).thenReturn(productsApiDTO);

        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
        verify(productsService).getProducts(1);

    }
}