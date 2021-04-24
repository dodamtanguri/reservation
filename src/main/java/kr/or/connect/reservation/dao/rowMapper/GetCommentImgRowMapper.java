package kr.or.connect.reservation.dao.rowMapper;

import kr.or.connect.reservation.dto.CommentImagesDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCommentImgRowMapper implements RowMapper<CommentImagesDTO> {

    @Override
    public CommentImagesDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        return CommentImagesDTO.builder()
                .id(resultSet.getInt("id"))
                .reservationId(resultSet.getInt("reservationInfoId"))
                .reservationUserCommentId(resultSet.getInt(""))
                .fileId(resultSet.getInt(""))
                .fileName(resultSet.getString(""))
                .saveFileName(resultSet.getString(""))
                .contentType(resultSet.getString(""))
                .createDate(resultSet.getTimestamp("create_date") != null ? resultSet.getTimestamp("create_date").toLocalDateTime() : null)
                .modifyDate(resultSet.getTimestamp("create_date") != null ? resultSet.getTimestamp("create_date").toLocalDateTime() : null)
                .build();
    }
}
