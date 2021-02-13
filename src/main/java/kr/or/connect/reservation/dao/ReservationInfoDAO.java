package kr.or.connect.reservation.dao;


import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.util.HashMap;
import java.util.Map;

import static kr.or.connect.reservation.dao.sql.reservationSQL.*;


@Repository
public class ReservationInfoDAO {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ReservationApiDTO> rowMapper = BeanPropertyRowMapper.newInstance(ReservationApiDTO.class);
    private SimpleJdbcInsert insertAction;

    @Autowired
    public ReservationInfoDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info")
                .usingGeneratedKeyColumns("id");
    }

    // reservationinfo insert
    public int insertReservationInfo(ReservationApiDTO reservationApiDTO) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(reservationApiDTO);
        return insertAction.executeAndReturnKey(params).intValue();
    }

    public ReservationApiDTO getReservationInfo(int userID) {
        try {
            Map<String,Integer> params = new HashMap<>();
            params.put("userID",userID);
            return jdbc.queryForObject(SELECT_RESERVATION_INFOS,params,rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


}







