package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.config.SecurityConfig;
import kr.or.connect.reservation.dto.ReservationPrice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;

import java.sql.Connection;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, SecurityConfig.class})
@WebAppConfiguration
public class ReservationPriceDAOTest {

    @Autowired
    DataSource dataSource;
    @Autowired
    ReservationPriceDAO dao;
    @Autowired
    private WebApplicationContext context;

    @Test
    public void configTest() throws Exception {
    }

    @Test
    public void connectionTest() throws Exception {
        Connection connection = dataSource.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    @DisplayName("Reservation Price Insert")
    public void insertPrice() throws Exception {
        ReservationPrice price = new ReservationPrice();
        price.setId(21);
        price.setReservationInfoId(17);
        price.setProductPriceId(3);
        price.setCount(2);

        assertNotNull(price);
        assertEquals(21,price.getId());
    }


}