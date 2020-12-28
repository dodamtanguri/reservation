package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.UserDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import java.sql.Connection;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class UserDAOTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    UserDAO userDAO;
    @Autowired
    UserRoleDAO userRoleDAO;

    @Test
    public void configTest() throws Exception{

    }
    @Test
    public void connectionTest() throws Exception {
        Connection connection = dataSource.getConnection();
        Assert.assertNotNull(connection);
    }
    @Test
    public void getUser() throws Exception {
        UserDto user = userDAO.getUserByEmail("kimjinsu@connect.co.kr");
        Assert.assertNotNull(user);
        Assert.assertEquals("김진수",user.getName());
    }

}