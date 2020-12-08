package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.DisplayinfosDAO;
import kr.or.connect.reservation.dto.DisplayinfosDTO;
import kr.or.connect.reservation.service.DisplayinfosService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.context.web.WebAppConfiguration;


import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@WebAppConfiguration
public class DisplayinfosServiceImplTest {
    @Mock
    DisplayinfosDAO displayinfosDAO;
    @InjectMocks
    DisplayinfosService displayinfosService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        List<DisplayinfosDTO> displayinfosDTO = displayinfosService.getDisplayInfos(3);
        when(displayinfosDAO.getDisplayInfos(3,0)).thenReturn(displayinfosDTO);
    }


}