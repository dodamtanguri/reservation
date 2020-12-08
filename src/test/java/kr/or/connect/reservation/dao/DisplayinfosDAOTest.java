package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.DisplayinfosDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class DisplayinfosDAOTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        DisplayinfosDAO displayinfosDAO = ac.getBean(DisplayinfosDAO.class);
        DisplayinfosDTO displayinfosDTO = new DisplayinfosDTO();
        List<DisplayinfosDTO> result = displayinfosDAO.getDisplayInfos(3,0);
        System.out.println(result);
    }

}