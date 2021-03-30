package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dao.rowMapper.GetInfosRowMapper;
import kr.or.connect.reservation.dao.rowMapper.InfoRowMapper;
import kr.or.connect.reservation.dao.rowMapper.PriceRowMapper;
import kr.or.connect.reservation.dto.ReservationInfos;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.dao.sql.reservationSQL.*;

@Repository
public class ReservationDAO {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertInfo, insertPrice;


    @Autowired
    public ReservationDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertInfo = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info")
                .usingGeneratedKeyColumns("id");
        this.insertPrice = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info_price")
                .usingGeneratedKeyColumns("id");
    }

    /*
    예약 등록 하기 
     */
    public int insertReservationInfo(ReservationApiDTO reservationInfo) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
        return insertInfo.executeAndReturnKey(params).intValue();
    }

    public int insertReservationPrice(ReservationPrice reservationPrice) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(reservationPrice);
        return insertPrice.executeAndReturnKey(params).intValue();
    }

    public ReservationApiDTO getReservationInfo(int reservationInfoId) {
        try {
            Map<String, Integer> params = new HashMap<>();
            params.put("reservationInfoId", reservationInfoId);
            return jdbc.queryForObject(SELECT_RESERVATION_INFOS, params, new InfoRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<ReservationPrice> getReservationPrice(int reservationPriceId) {
        try {
            Map<String, Integer> params = new HashMap<>();
            params.put("reservationPriceId", reservationPriceId);
            return jdbc.query(SELECT_RESERVATION_PRICES, params, new PriceRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    /*
    예약 조회 하기
     */
    public List<ReservationInfos> getReservationInfoApiDTO(int userID) {

        try {

            Map<String, Integer> params = new HashMap<>();
            params.put("userID", userID);
            return jdbc.query(SELECT_GETRESERVATION_INFOS, params, new GetInfosRowMapper());

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /*
    예약 취소 하기
     */
    public int cancelReservation(int id, int userID) {
        try {
            Map<String, Integer> params = new HashMap<>();
            params.put("id", id);
            params.put("userID", userID);
            return jdbc.update(UPDATE_CANCEL_FLAG, params);
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }

}
