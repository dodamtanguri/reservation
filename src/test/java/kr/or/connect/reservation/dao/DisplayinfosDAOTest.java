package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.ProductsDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class DisplayinfosDAOTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductsDAO displayinfosDAO = ac.getBean(ProductsDAO.class);
        ProductsDTO displayinfosDTO = new ProductsDTO();
        //List<DisplayinfosDTO> result = displayinfosDAO.getDisplayInfos(3,0);
        //System.out.println(result);
    }

}