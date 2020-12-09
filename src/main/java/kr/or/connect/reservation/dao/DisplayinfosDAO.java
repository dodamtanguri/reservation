package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.DisplayinfosDTO;
import kr.or.connect.reservation.dto.api.DisplayinfosApiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.dao.sql.DisplayinfosSQL.SELECT_PRODUCT_LIST;

@Repository
public class DisplayinfosDAO {
    private NamedParameterJdbcTemplate jdbc;
    @Autowired
    public DisplayinfosDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
    public List<DisplayinfosDTO> getDisplayInfos(Integer categoryId, Integer start) {
        Map<String, Integer> params = new HashMap<>();
        params.put("CATEGORYID", categoryId);
        params.put("START", start);
        return jdbc.query(SELECT_PRODUCT_LIST, params, new RowMapper<DisplayinfosDTO>() {
            public DisplayinfosDTO mapRow(ResultSet resultSet, int i) throws SQLException {
                DisplayinfosDTO displayinfosDTO = new DisplayinfosDTO();
                displayinfosDTO.setProductId(resultSet.getInt("productId"));
                displayinfosDTO.setCategoryId(categoryId);
                displayinfosDTO.setDisplayInfoId(resultSet.getInt("displayInfoId"));
                displayinfosDTO.setCategoryName(resultSet.getString("name"));
                displayinfosDTO.setProductDescription(resultSet.getString("description"));
                displayinfosDTO.setProductContent(resultSet.getString("content"));
                displayinfosDTO.setProductEvent(resultSet.getString("event"));
                displayinfosDTO.setOpeningHours(resultSet.getString("opening_hours"));
                displayinfosDTO.setPlaceName(resultSet.getString("place_name"));
                displayinfosDTO.setPlaceLot(resultSet.getString("place_lot"));
                displayinfosDTO.setPlaceStreet(resultSet.getString("place_street"));
                displayinfosDTO.setTel(resultSet.getString("tel"));
                displayinfosDTO.setHomepage(resultSet.getString("homepage"));
                displayinfosDTO.setEmail(resultSet.getString("email"));
                displayinfosDTO.setCreateDate(resultSet.getString("create_date"));
                displayinfosDTO.setModifyDate(resultSet.getString("modify_date"));
                displayinfosDTO.setFileId(resultSet.getInt("file_id"));
                return displayinfosDTO;
            }
        });

    }
}

