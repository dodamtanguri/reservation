package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.dao.sql.CommentSQL.*;

@Repository
public class CommentDAO {

    private final NamedParameterJdbcTemplate jdbc;
    private final SimpleJdbcInsert insertComment;
    private final SimpleJdbcInsert insertFile;
    private final SimpleJdbcInsert insertImg;

    @Autowired
    public CommentDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertComment = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_user_comment")
                .usingGeneratedKeyColumns("id");
        this.insertFile = new SimpleJdbcInsert(dataSource)
                .withTableName("file_info")
                .usingGeneratedKeyColumns("id");
        this.insertImg = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_user_comment_image")
                .usingGeneratedKeyColumns("product_id");
    }

    public List<CommentDTO> getComment(int productId, int start) {
        Map<String, Integer> params = new HashMap<String, Integer>() {
            {
                put("productId", productId);
                put("START", start);
            }
        };

        return jdbc.query(SELECT_COMMENT_LIST, params, (resultSet, i) -> {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setId(resultSet.getInt("id"));
            commentDTO.setProductId(productId);
            commentDTO.setReservationInfoId(resultSet.getInt("reservationInfoId"));
            commentDTO.setScore(resultSet.getInt("score"));
            commentDTO.setReservationEmail(resultSet.getString("reservationEmail"));
            commentDTO.setComment(resultSet.getString("comment"));
            commentDTO.setCreateDate(resultSet.getString("create_date"));
            commentDTO.setModifyDate(resultSet.getString("modify_date"));

            List<CommentImagesDTO> commentImagesDTOS = getCommentImage(resultSet.getInt("reservationInfoId"));
            if (commentImagesDTOS != null)
                commentDTO.setReservationUserCommentImages(commentImagesDTOS);
            return commentDTO;

        });
    }

    public List<CommentImagesDTO> getCommentImage(Integer productId) {
        Map<String, Object> params = new HashMap<String, Object>() {
            {
                put("productId", productId);
            }
        };

        try {
            return jdbc.query(SELECT_COMMENT_IMAGE, params, (resultSet, i) -> {
                CommentImagesDTO commentImagesDTO = new CommentImagesDTO();
                commentImagesDTO.setCommentImageId(resultSet.getInt("reservationCommentImageId"));
                commentImagesDTO.setReservationId(resultSet.getInt("reservationInfoId"));
                commentImagesDTO.setCommentImageId(resultSet.getInt("reservationCommentId"));
                commentImagesDTO.setFileId(resultSet.getInt("file_id"));


                return commentImagesDTO;
            });
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();

        }

    }

    public int getTotalCount(Integer productId) {
        Map<String, Integer> params = new HashMap<String, Integer>() {
            {
                put("productId", productId);
            }
        };

        return jdbc.queryForObject(SELECT_COMMENT_TOTALCOUNT, params, Integer.class);
    }

    @Transactional
    public int getProductId(int reservationInfoId, int userId) {
        Map<String, Integer> params = new HashMap<String, Integer>() {
            {
                put("reservationInfoId", reservationInfoId);
                put("userId", userId);
            }
        };
        return jdbc.queryForObject(SELECT_COMMENT_PRODUCTID, params, Integer.class);


    }

    @Transactional
    public int insertComment(InsertCommentDTO insert) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(insert);
        return insertComment.executeAndReturnKey(params).intValue();
    }

    @Transactional
    public int insertCommentFile(InsertFileDTO file) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(file);
        return insertFile.executeAndReturnKey(params).intValue();
    }

    @Transactional
    public int insertCommentImg(InsertCommentImgDTO img) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(img);
        return insertImg.executeAndReturnKey(params).intValue();
    }


}
