package kr.or.connect.reservation.dao;


import kr.or.connect.reservation.dto.ReservationPriceBody;
import kr.or.connect.reservation.dto.reservationInfoDTO;
import kr.or.connect.reservation.dto.reservationPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;


@Repository
public class reservationDAO {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;

    @Autowired
    public reservationDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource);
    }

    public int insertResInfo(reservationInfoDTO infoDTO) {
        insertAction.withTableName("reservation_info")
                    .usingGeneratedKeyColumns("id");
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(infoDTO);
        System.out.println(parameterSource);
        return insertAction.executeAndReturnKey(parameterSource).intValue();
    }
    public int insertResPrice(reservationPriceDto priceDTO) {
        insertAction.withTableName("reservation_info_price")
                    .usingGeneratedKeyColumns("id");
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(priceDTO);
        System.out.println(parameterSource);
        return insertAction.executeAndReturnKey(parameterSource).intValue();
    }

    public List<ReservationPriceBody> insertResPrice() {
    }
}
