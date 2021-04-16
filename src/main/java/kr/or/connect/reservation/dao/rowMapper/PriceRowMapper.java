package kr.or.connect.reservation.dao.rowMapper;

import kr.or.connect.reservation.dto.ReservationPrice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PriceRowMapper implements RowMapper<ReservationPrice> {
    @Override
    public ReservationPrice mapRow(ResultSet resultSet, int i) throws SQLException {
        return ReservationPrice.builder()
                .id(resultSet.getInt("Id"))
                .productPriceId(resultSet.getInt("product_price_id"))
                .count(resultSet.getInt("count"))
                .reservationInfoId(resultSet.getInt("reservation_info_id"))
                .build();


    }
}
