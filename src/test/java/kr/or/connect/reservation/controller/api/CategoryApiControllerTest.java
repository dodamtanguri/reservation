package kr.or.connect.reservation.controller.api;

import kr.or.connect.reservation.dto.CategoriesDTO;
import kr.or.connect.reservation.dto.api.CategoriesApiDto;
import kr.or.connect.reservation.service.CategoriesService;
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


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebAppConfiguration
public class CategoryApiControllerTest {
    @InjectMocks
    public CategoryApiController categoryApiController;

    @Mock
    CategoriesService categoriesService;
    private MockMvc mockMvc;

    @Before
    public void createController() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(categoryApiController).build();
    }

    @Test
    public void getCategory() throws Exception {
        CategoriesDTO categoriesDTO = new CategoriesDTO();
        categoriesDTO.setId(1010);
        categoriesDTO.setCount(2020);
        categoriesDTO.setName("Hello Test");
        List<CategoriesApiDto> items = Arrays.asList(new CategoriesApiDto());


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/categories").contentType(MediaType.APPLICATION_JSON);
        when(categoriesService.getCategories()).thenReturn((CategoriesApiDto) items);

        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
        verify(categoriesService).getCategories();
    }


}