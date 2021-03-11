package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.config.SecurityConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, SecurityConfig.class})
@WebAppConfiguration

public class reservationDAOTest {


    @Autowired
    DataSource dataSource;



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


}
