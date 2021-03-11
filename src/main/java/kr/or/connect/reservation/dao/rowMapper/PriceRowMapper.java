package kr.or.connect.reservation.dao.rowMapper;

import kr.or.connect.reservation.dto.ReservationPrice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PriceRowMapper implements RowMapper<ReservationPrice> {
    @Override
    public ReservationPrice mapRow(ResultSet resultSet, int i) throws SQLException {
        ReservationPrice price = new ReservationPrice();
        price.setId(resultSet.getInt("Id"));
        price.setProductPriceId(resultSet.getInt("product_price_id"));
        price.setCount(resultSet.getInt("count"));
        price.setReservationInfoId(resultSet.getInt("reservation_info_id"));

        return price;
    }
}
