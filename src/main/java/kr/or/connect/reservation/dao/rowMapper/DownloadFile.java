package kr.or.connect.reservation.dao.rowMapper;

import kr.or.connect.reservation.dto.InsertFileDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DownloadFile implements RowMapper<InsertFileDTO> {

    @Override
    public InsertFileDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        return InsertFileDTO.builder()
                .fileName(resultSet.getString("file_name"))
                .saveFileName(resultSet.getString("save_file_name"))
                .contentType(resultSet.getString("content_type"))
                .build();
    }
}
