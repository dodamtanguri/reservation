package kr.or.connect.reservation.dao.rowMapper;

import kr.or.connect.reservation.dto.api.GetReservationInfoApiDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetInfosRowMapper implements RowMapper<GetReservationInfoApiDTO> {

    @Override
    public GetReservationInfoApiDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
