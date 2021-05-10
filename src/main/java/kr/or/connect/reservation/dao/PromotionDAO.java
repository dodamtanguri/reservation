package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.PromotionDTO;
import kr.or.connect.reservation.dto.api.PromotionApiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static kr.or.connect.reservation.dao.sql.PromotionSQL.SELECT_PROMOTION_LIST;

@Repository
public class PromotionDAO {

    private final NamedParameterJdbcTemplate jdbc;

    @Autowired
    public PromotionDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public PromotionApiDto getPromotionList() {
        List<PromotionDTO> promotionDtoList = jdbc.query(SELECT_PROMOTION_LIST, (resultSet, rowNum) -> {
            PromotionDTO promotionDto = new PromotionDTO();
            promotionDto.setId(resultSet.getInt("PromotionId"));
            promotionDto.setProductId(resultSet.getInt("ProductId"));
            promotionDto.setCategoryId(resultSet.getInt("CategoryId"));
            promotionDto.setCategoryName(resultSet.getString("name"));
            promotionDto.setProductDescription(resultSet.getString("description"));
            promotionDto.setFileId(resultSet.getInt("fileId"));
            return promotionDto;
        });
        PromotionApiDto promotionApiDto = new PromotionApiDto();
        promotionApiDto.setItems(promotionDtoList);
        return promotionApiDto;
    }


}
