package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.CategoriesDTO;
import kr.or.connect.reservation.dto.api.CategoriesApiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;


import static kr.or.connect.reservation.dao.sql.CategoriesSQL.SELECT_CATEGORY;

@Repository
public class CategoriesDAO {

    private NamedParameterJdbcTemplate jdbc;

    //JDBC
    @Autowired
    public CategoriesDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    //Category 의 id, 이름, counts
    public CategoriesApiDto getCategories() {
        List<CategoriesDTO> categoryList = jdbc.query(SELECT_CATEGORY, (resultSet, rowNum) -> {
            CategoriesDTO categoriesDTO = new CategoriesDTO();
            categoriesDTO.setId(resultSet.getInt("id"));
            categoriesDTO.setName(resultSet.getString("name"));
            categoriesDTO.setCount(resultSet.getInt("count"));
            return categoriesDTO;
        });

        CategoriesApiDto categoriesApiDto = new CategoriesApiDto();
        categoriesApiDto.setItems(categoryList);
        return categoriesApiDto;

    }
}
