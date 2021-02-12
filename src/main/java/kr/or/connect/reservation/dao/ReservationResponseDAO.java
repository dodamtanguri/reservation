package kr.or.connect.reservation.dao;

import io.swagger.models.auth.In;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static kr.or.connect.reservation.dao.sql.reservationSQL.*;

@Repository
public class ReservationResponseDAO {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ReservationApiDTO> rowMapper = BeanPropertyRowMapper.newInstance(ReservationApiDTO.class);

    @Autowired
    public ReservationResponseDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public ReservationApiDTO getReservationResponse(int reservationInfoId) {
        try {
            Map<String, Integer> params = new HashMap<>();
            params.put("reservationInfoId", reservationInfoId);
            return jdbc.queryForObject(SELECT_RESERVATION_INFOS, params, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
