package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.CategoriesDTO;
import kr.or.connect.reservation.dto.api.CategoriesApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;


import static kr.or.connect.reservation.dao.sql.CategoriesSQL.SELECT_CATEGORY;

@Repository
public class CategoriesDAO {

    private NamedParameterJdbcTemplate jdbc;


    @Autowired
    public CategoriesDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }


    public CategoriesApiDTO getCategories() {
        List<CategoriesDTO> categoryList = jdbc.query(SELECT_CATEGORY, (resultSet, rowNum) -> {
            CategoriesDTO categoriesDTO = new CategoriesDTO();
            categoriesDTO.setId(resultSet.getInt("id"));
            categoriesDTO.setName(resultSet.getString("name"));
            categoriesDTO.setCount(resultSet.getInt("count"));
            return categoriesDTO;
        });

        CategoriesApiDTO categoriesApiDto = new CategoriesApiDTO();
        categoriesApiDto.setItems(categoryList);
        return categoriesApiDto;

    }
}
