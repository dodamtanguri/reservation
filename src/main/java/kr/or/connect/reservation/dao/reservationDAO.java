package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.api.reservationApiDTO;
import kr.or.connect.reservation.dto.reservationInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Repository
public class reservationDAO {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;

    @Autowired
    public reservationDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info");


    }

    public void insertResInfo(reservationInfoDTO infoDTO) {
        int result = insertAction.execute(new BeanPropertySqlParameterSource(infoDTO));

    }
}
