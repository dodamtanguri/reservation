package kr.or.connect.reservation.service.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.connect.reservation.dao.CategoriesDAO;
import kr.or.connect.reservation.dto.CategoriesDTO;
import kr.or.connect.reservation.dto.api.CategoriesApiDTO;

@WebAppConfiguration
public class CategoriesServiceImplTest {
    @InjectMocks
    public CategoriesServiceImpl categoriesService;

    @Mock
    public CategoriesDAO categoriesDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCategories() {
        // given
        CategoriesDTO category = new CategoriesDTO();
        category.setId(1);
        category.setName("전시");
        category.setCount(10);

        List<CategoriesDTO> categories = new ArrayList<>();
        categories.add(category);

        CategoriesApiDTO actual = new CategoriesApiDTO();
        actual.setItems(categories);

        when(categoriesDAO.getCategories()).thenReturn(actual);

        // when
        CategoriesApiDTO result = categoriesService.getCategories();

        // then
        assertThat(actual, is(result));

        // verify
        verify(categoriesDAO, times(1)).getCategories();
    }
}