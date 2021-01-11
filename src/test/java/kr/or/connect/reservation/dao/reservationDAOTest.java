package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.reservationInfoDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class reservationDAOTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    reservationDAO dao;

    @Test
    public void configTest() throws Exception {

    }

    @Test
    public void connectionTest() throws Exception {
        Connection connection = dataSource.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void insertInfo() throws Exception {
        reservationInfoDTO infoDTO = new reservationInfoDTO();
        infoDTO.setId(1010);
        infoDTO.setProductId(2020);
        infoDTO.setDisplay_info_id(4040);
        infoDTO.setUserId(3030);
        infoDTO.setreservationDate(new Timestamp(System.currentTimeMillis()));
        infoDTO.setCancelFlag(0);
       // infoDTO.setcreateDate(new Timestamp(System.currentTimeMillis()));
        dao.insertResInfo(infoDTO);
        Assert.assertNotNull(infoDTO);
        Assert.assertEquals("1010", infoDTO.getId());
    }
}