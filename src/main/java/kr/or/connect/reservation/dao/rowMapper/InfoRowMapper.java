package kr.or.connect.reservation.dao.rowMapper;

import kr.or.connect.reservation.dto.api.ReservationApiDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoRowMapper implements RowMapper<ReservationApiDTO> {
    @Override
    public ReservationApiDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        ReservationApiDTO Info = new ReservationApiDTO();
        Info.setId(resultSet.getInt("id"));
        Info.setProductId(resultSet.getInt("product_id"));
        Info.setCancelFlag(resultSet.getInt("cancel_flag"));
        Info.setDisplayInfoId(resultSet.getInt("display_info_id"));
        Info.setUserId(resultSet.getInt("user_id"));
        Info.setReservationDate(resultSet.getDate("reservation_date"));
        Info.setCreateDate(resultSet.getDate("create_date"));
        Info.setModifyDate(resultSet.getDate("modify_date"));
        return Info;
    }
}
