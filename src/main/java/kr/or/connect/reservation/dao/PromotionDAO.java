package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.PromotionDto;
import kr.or.connect.reservation.dto.api.DisplayinfosApiDto;
import kr.or.connect.reservation.dto.api.PromotionApiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static kr.or.connect.reservation.dao.sql.PromotionSQL.SELECT_PROMOTION_LIST;

@Repository
public class PromotionDAO {

    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public PromotionDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
    public PromotionApiDto getPromotionList() {
        List<PromotionDto> promotionDtoList = jdbc.query(SELECT_PROMOTION_LIST, (resultSet, rowNum) -> {
            PromotionDto promotionDto = new PromotionDto();
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
