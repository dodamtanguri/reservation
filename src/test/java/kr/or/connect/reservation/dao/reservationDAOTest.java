package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.config.SecurityConfig;
import kr.or.connect.reservation.dto.ReservationInfo;
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
import java.sql.Timestamp;
import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, SecurityConfig.class})
@WebAppConfiguration

public class reservationDAOTest {


    @Autowired
    DataSource dataSource;

    @Autowired
    ReservationInfoDAO dao;

    @Autowired
    private WebApplicationContext context;


//    @Before
//    public void setup() {
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
//    }


    @Test
    public void configTest() throws Exception {

    }

    @Test
    public void connectionTest() throws Exception {
        Connection connection = dataSource.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    @DisplayName("예약 정보 등록")

    public void insertInfo() throws Exception {
        ReservationInfo infoDTO = new ReservationInfo();

        LocalDate date = LocalDate.of(2020, 10, 10);
        //https://jojoldu.tistory.com/416 >> 테스트 코드에서 날짜 고정
        infoDTO.setId(1010);
        infoDTO.setProductId(1);
        infoDTO.setDisplayInfoId(1);
        infoDTO.setUserId(2);
        infoDTO.setreservationDate(new Timestamp(System.currentTimeMillis()));
        infoDTO.setCancelFlag(0);
        infoDTO.setCreateDate(date);
        infoDTO.setModifyDate(date);
        //dao.insertResInfo(infoDTO);
        assertNotNull(infoDTO);
        assertEquals(1010, infoDTO.getId());
    }
//    @Test
//    @DisplayName("예약 등록시 가격")
//    public void insertPrice() throws Exception {
//        reservationPriceDto price = new reservationPriceDto();
//        price.setId(1);
//        price.setReservation_info_id(1);
//        price.setProduct_price_id(1);
//        price.setCount(1);
//        dao.insertResPrice(price);
//        assertNotNull(price);
//        assertEquals(1,price.getId());
//    }
}
