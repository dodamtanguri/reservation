package kr.or.connect.reservation.dao;


import kr.or.connect.reservation.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.dao.sql.DisplayInfoSQL.*;

@Repository
public class DisplayInfosDAO {
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public DisplayInfosDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<DisplayInfosDTO> getProduct(Integer displayInfoId) {
        Map<String, Integer> params = new HashMap<String, Integer>() {
            {
                put("displayInfoId", displayInfoId);
            }
        };
        return jdbc.query(SELECT_DISPLAYINFO_BY_PRODUCT, params, (resultSet, i) -> {
            DisplayInfosDTO displayInfosDTO = new DisplayInfosDTO();
            displayInfosDTO.setProductId(resultSet.getInt("productId"));
            displayInfosDTO.setCategoryId(resultSet.getInt("categoryId"));
            displayInfosDTO.setDisplayInfoId(displayInfoId);
            displayInfosDTO.setCategoryName(resultSet.getString("name"));
            displayInfosDTO.setProductDescription(resultSet.getString("description"));
            displayInfosDTO.setProductContent(resultSet.getString("content"));
            displayInfosDTO.setProductEvent(resultSet.getString("event"));
            displayInfosDTO.setOpeningHours(resultSet.getString("opening_hours"));
            displayInfosDTO.setPlaceName(resultSet.getString("place_name"));
            displayInfosDTO.setPlaceLot(resultSet.getString("place_lot"));
            displayInfosDTO.setPlaceStreet(resultSet.getString("place_street"));
            displayInfosDTO.setTel(resultSet.getString("tel"));
            displayInfosDTO.setHomepage(resultSet.getString("homepage"));
            displayInfosDTO.setEmail(resultSet.getString("email"));
            displayInfosDTO.setCreateDate(resultSet.getString("create_date"));
            displayInfosDTO.setModifyDate(resultSet.getString("modify_date"));
            displayInfosDTO.setFileId(resultSet.getInt("file_id"));
            return displayInfosDTO;
        });
    }

    public List<ProductImagesDTO> getProductImage(Integer displayInfoId) {
        Map<String, Integer> params = new HashMap<String, Integer>() {
            {
                put("displayInfoId", displayInfoId);
            }
        };
        return jdbc.query(SELECT_DISPLAYINFO_BY_PRODUCT_IMAGE, params, (resultSet, i) -> {
            ProductImagesDTO productImagesDTO = new ProductImagesDTO();
            productImagesDTO.setProductId(resultSet.getInt("productId"));
            productImagesDTO.setProductImageId(resultSet.getInt("productImageId"));
            productImagesDTO.setType(resultSet.getString("type"));
            productImagesDTO.setFileInfoId(resultSet.getInt("fileInfoId"));
            productImagesDTO.setFileName(resultSet.getString("file_name"));
            productImagesDTO.setSaveFileName(resultSet.getString("save_file_name"));
            productImagesDTO.setContentType(resultSet.getString("content_type"));
            productImagesDTO.setDeleteFlag(resultSet.getInt("delete_flag"));
            productImagesDTO.setCreateDate(resultSet.getString("create_date"));
            productImagesDTO.setModifyDate(resultSet.getString("modify_date"));
            return productImagesDTO;
        });
    }

    public List<DisplayInfosImageDTO> getDisplayinfoImage(Integer displayInfoId) {
        Map<String, Integer> params = new HashMap<String, Integer>() {
            {
                put("displayInfoId", displayInfoId);
            }
        };
        return jdbc.query(SELECT_DISPLAYINFO_IMAGE, params, (resultSet, i) -> {
            DisplayInfosImageDTO displayInfosImageDTO = new DisplayInfosImageDTO();
            displayInfosImageDTO.setDisplayInfoImageId(resultSet.getInt("id"));
            displayInfosImageDTO.setDisplayInfoId(resultSet.getInt("displayInfoId"));
            displayInfosImageDTO.setFileId(resultSet.getInt("fileId"));
            displayInfosImageDTO.setFileName(resultSet.getString("file_name"));
            displayInfosImageDTO.setSaveFileName(resultSet.getString("save_file_name"));
            displayInfosImageDTO.setContentType(resultSet.getString("content_type"));
            displayInfosImageDTO.setDeleteFlag(resultSet.getInt("delete_flag"));
            displayInfosImageDTO.setCreateDate(resultSet.getString("create_date"));
            displayInfosImageDTO.setModifyDate(resultSet.getString("modify_date"));
            return displayInfosImageDTO;
        });
    }

    public int avgScore(Integer displayInfoId) {
        Map<String, Integer> params = new HashMap<String, Integer>() {
            {
                put("displayInfoId", displayInfoId);
            }
        };
        return jdbc.queryForObject(SELECT_COMMENT_AVERAGE, params, Integer.class);
    }

    public List<ProductPricesDTO> getProductPrices(Integer displayInfoId) {
        Map<String, Integer> params = new HashMap<String, Integer>() {
            {
                put("displayInfoId", displayInfoId);
            }
        };
        return jdbc.query(SELECT_PRODUCT_PRICES, params, (resultSet, i) -> {
            ProductPricesDTO productPricesDTO = new ProductPricesDTO();
            productPricesDTO.setProductPriceId(resultSet.getInt("id"));
            productPricesDTO.setProductId(resultSet.getInt("productId"));
            productPricesDTO.setPriceTypeName(resultSet.getString("price_type_name"));
            productPricesDTO.setPrice(resultSet.getInt("price"));
            productPricesDTO.setDiscountRate(resultSet.getInt("discount_rate"));
            productPricesDTO.setCreateDate(resultSet.getString("create_date"));
            productPricesDTO.setModifyDate(resultSet.getString("modify_date"));
            return productPricesDTO;
        });
    }

}
