package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dao.rowMapper.GetInfosRowMapper;
import kr.or.connect.reservation.dao.rowMapper.InfoRowMapper;
import kr.or.connect.reservation.dao.rowMapper.PriceRowMapper;
import kr.or.connect.reservation.dto.ReservationInfos;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.dao.sql.reservationSQL.*;

@Repository
public class ReservationDAO {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate jdbc;
    private final SimpleJdbcInsert insertInfo;


    @Autowired
    public ReservationDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertInfo = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info")
                .usingGeneratedKeyColumns("id");
    }

    /*
    예약 등록 하기 
     */
    public ReservationApiDTO insertReservationInfo(ReservationApiDTO reservationInfo) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
        reservationInfo.setId(insertInfo.executeAndReturnKey(params).intValue());
        jdbcTemplate.batchUpdate(INSERT_RESERVATION_PRICES, new BatchPreparedStatementSetter() {
            @Override

            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                ReservationPrice price = reservationInfo.getPrices().get(i);
                preparedStatement.setInt(1, reservationInfo.getId());
                preparedStatement.setInt(2, price.getProductPriceId());
                preparedStatement.setInt(3, price.getCount());
            }

            @Override
            public int getBatchSize() {
                return reservationInfo.getPrices().size();
            }
        });
//        for (int i = 0; i<reservationInfo.getPrices().size(); i++) {
//            reservationInfo.getPrices().get(i).setReservationInfoId(reservationInfo.getId());
//            reservationInfo.getPrices().get(i).setId();
//        }

        return reservationInfo;
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

    public List<ReservationPrice> getReservationPrice(int reservationInfoId) {
        try {
            Map<String, Integer> params = new HashMap<>();
            params.put("reservationInfoId", reservationInfoId);
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
            return jdbc.query(SELECT_GET_RESERVATION_INFOS, params, new GetInfosRowMapper());

        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
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
