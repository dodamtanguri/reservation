package kr.or.connect.reservation.dao.rowMapper;

import kr.or.connect.reservation.dto.ReservationInfos;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetInfosRowMapper implements RowMapper<ReservationInfos> {

    @Override
    public ReservationInfos mapRow(ResultSet resultSet, int i) throws SQLException {
        ReservationInfos Info = new ReservationInfos();
        Info.setId(resultSet.getInt("id"));
        Info.setProductId(resultSet.getInt("product_id"));
        Info.setDisplayInfoId(resultSet.getInt("display_info_id"));
        Info.setCancelFlag(resultSet.getInt("cancel_flag"));
        Info.setProductDescription(resultSet.getString("description"));
        Info.setProductContent(resultSet.getString("content"));
        Info.setUserId(resultSet.getInt("user_id"));
        Info.setSumPrice(resultSet.getInt("sumPrice"));
        Info.setReservationDate(resultSet.getDate("reservation_date"));
        Info.setCreateDate(resultSet.getDate("create_date"));
        Info.setModifyDate(resultSet.getDate("modify_date"));
        return Info;
    }
}
