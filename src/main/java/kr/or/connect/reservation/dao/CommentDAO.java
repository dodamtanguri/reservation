package kr.or.connect.reservation.dao;

import io.swagger.models.auth.In;
import kr.or.connect.reservation.dto.CommentDTO;
import kr.or.connect.reservation.dto.CommentImagesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.dao.sql.CommentSQL.*;

@Repository
public class CommentDAO {

    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public CommentDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
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
}
