package kr.or.connect.reservation.dao.rowMapper;

import kr.or.connect.reservation.dto.CommentDTO;
import kr.or.connect.reservation.dto.InsertCommentDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCommentRowMapper implements RowMapper<InsertCommentDTO> {


    @Override
    public InsertCommentDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        CommentDTO commentDTO = CommentDTO.builder()
                .id(resultSet.getInt("id"))
                .productId(resultSet.getInt("product_id"))
                .reservationInfoId(resultSet.getInt("reservation_info_id"))
                .score(resultSet.getInt("score"))
                .comment(resultSet.getString("comment"))
                .createDate()
        return null;
    }
}
