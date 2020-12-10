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
        this.mockMvc = MockMvcBuilders.standaloneSetup(displayinfosApiController).build();
    }
    //total Product
    @Test
    public void getTotalCount() throws Exception {
        DisplayinfosDTO displayinfosDTO = new DisplayinfosDTO();
        displayinfosDTO.setCategoryId(3);
        DisplayinfosApiDto displayinfosApiDto = new DisplayinfosApiDto();

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/displayinfos").contentType(MediaType.APPLICATION_JSON);
        when(displayinfosService.getDisplayInfos(3)).thenReturn(displayinfosApiDto);

        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
        verify(displayinfosService).getDisplayInfos(1);

    }
}