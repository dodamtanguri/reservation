package kr.or.connect.reservation.dao.rowMapper;

import kr.or.connect.reservation.dto.CommentDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCommentRowMapper implements RowMapper<CommentDTO> {


    @Override
    public CommentDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        return CommentDTO.builder()
                .id(resultSet.getInt("id"))
                .productId(resultSet.getInt("product_id"))
                .reservationInfoId(resultSet.getInt("reservation_info_id"))
                .score(resultSet.getInt("score"))
                .userId(resultSet.getInt("user_id"))
                .comment(resultSet.getString("comment"))
                .build();

    }
}
