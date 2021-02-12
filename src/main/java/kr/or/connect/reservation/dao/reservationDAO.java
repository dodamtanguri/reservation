package kr.or.connect.reservation.dao;




import kr.or.connect.reservation.dto.ReservationDTO;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import org.springframework.stereotype.Repository;

import javax.sql.DataSource;



@Repository
public class reservationDAO {
    private NamedParameterJdbcTemplate jdbc;

    public reservationDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public ReservationApiDTO addReservation (ReservationDTO dto) {

    }



}
