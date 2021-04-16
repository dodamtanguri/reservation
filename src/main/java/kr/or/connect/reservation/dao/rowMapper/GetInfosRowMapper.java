package kr.or.connect.reservation.dao.rowMapper;

import kr.or.connect.reservation.dto.ReservationInfos;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetInfosRowMapper implements RowMapper<ReservationInfos> {

    @Override
    public ReservationInfos mapRow(ResultSet resultSet, int i) throws SQLException {

        return ReservationInfos.builder()
                .id(resultSet.getInt("id"))
                .productId(resultSet.getInt("product_id"))
                .displayInfoId(resultSet.getInt("display_info_id"))
                .cancelFlag(resultSet.getInt("cancel_flag"))
                .productDescription(resultSet.getString("description"))
                .productContent(resultSet.getString("content"))
                .userId(resultSet.getInt("user_id"))
                .sumPrice(resultSet.getInt("sumPrice"))
                .reservationDate(resultSet.getDate("reservation_date").toLocalDate())
                .createDate(resultSet.getTimestamp("create_date").toLocalDateTime())
                .modifyDate(resultSet.getTimestamp("modify_date").toLocalDateTime())
                .build();
    }
}
