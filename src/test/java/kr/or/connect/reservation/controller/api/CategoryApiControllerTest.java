package kr.or.connect.reservation.controller.api;

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



import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
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

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/categories").contentType(MediaType.APPLICATION_JSON);
        given(this.categoriesService.getCategories()).willReturn(new CategoriesApiDto());

        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
        verify(categoriesService).getCategories();
    }


}