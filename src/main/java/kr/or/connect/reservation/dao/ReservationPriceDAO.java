package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.ReservationPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.dao.sql.reservationSQL.SELECT_RESERVATION_PRICES;

@Repository
public class ReservationPriceDAO {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ReservationPrice> rowMapper = BeanPropertyRowMapper.newInstance(ReservationPrice.class);
    private SimpleJdbcInsert insertAction;

    @Autowired
    public ReservationPriceDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info_price")
                .usingGeneratedKeyColumns("id");
    }

    public void insertReservationPrice(ReservationPrice reservationPrice) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(reservationPrice);
        insertAction.execute(params);
    }

    public List<ReservationPrice> getReservationPrice(int reservationInfoId) {
        try {
            Map<String, Integer> params = new HashMap<>();
            params.put("reservationInfoId", reservationInfoId);
            return jdbc.query(SELECT_RESERVATION_PRICES, params, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
