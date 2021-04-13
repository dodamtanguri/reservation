package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dao.rowMapper.GetInfosRowMapper;
import kr.or.connect.reservation.dao.rowMapper.PriceRowMapper;
import kr.or.connect.reservation.dto.InsertReservationInfo;
import kr.or.connect.reservation.dto.ReservationInfos;
import kr.or.connect.reservation.dto.ReservationPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.dao.sql.reservationSQL.*;

@Repository
public class ReservationDAO {
    private final NamedParameterJdbcTemplate jdbc;
    private final SimpleJdbcInsert insertInfo;
    private final SimpleJdbcInsert insertPrice;


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

    @Transactional
    public int insertReservationInfo(InsertReservationInfo insertReservationInfo) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(insertReservationInfo);
        return insertInfo.executeAndReturnKey(params).intValue();


    }

    @Transactional
    public void insertReservationPriceInfo(List<ReservationPrice> prices) {
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(prices);
        insertPrice.executeBatch(batch);

    }

    @Transactional
    public List<ReservationPrice> getReservationPriceInfo(int reservationInfoId, int limit) {
        try {
            Map<String, Integer> params = new HashMap<String, Integer>() {
                {
                    put("reservationInfoId", reservationInfoId);
                    put("limit", limit);
                }
            };
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
