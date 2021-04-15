package kr.or.connect.reservation.dao.rowMapper;

import kr.or.connect.reservation.dto.ReservationInfos;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetInfosRowMapper implements RowMapper<ReservationInfos> {

    @Override
    public ReservationInfos mapRow(ResultSet resultSet, int i) throws SQLException {
        ReservationInfos infos = new ReservationInfos();
        infos.setId(resultSet.getInt("id"));
        infos.setProductId(resultSet.getInt("product_id"));
        infos.setDisplayInfoId(resultSet.getInt("display_info_id"));
        infos.setCancelFlag(resultSet.getInt("cancel_flag"));
        infos.setProductDescription(resultSet.getString("description"));
        infos.setProductContent(resultSet.getString("content"));
        infos.setUserId(resultSet.getInt("user_id"));
        infos.setSumPrice(resultSet.getInt("sumPrice"));
        infos.setReservationDate(resultSet.getDate("reservation_date").toLocalDate());
        infos.setCreateDate(resultSet.getTimestamp("create_date").toLocalDateTime());
        infos.setModifyDate(resultSet.getTimestamp("modify_date").toLocalDateTime());
        return infos;
    }
}
