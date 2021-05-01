package kr.or.connect.reservation.dao;

import kr.or.connect.reservation.dao.rowMapper.DownloadFile;
import kr.or.connect.reservation.dao.rowMapper.GetCommentImgRowMapper;
import kr.or.connect.reservation.dao.rowMapper.GetCommentRowMapper;
import kr.or.connect.reservation.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
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

    public List<CommentDTO> getCommentList(int productId, int start, int userId) {
        Map<String, Integer> params = new HashMap<String, Integer>() {
            {
                put("userId", userId);
                put("productId", productId);
                put("START", start);
            }
        };
        return jdbc.query(SELECT_COMMENT_LIST, params, new GetCommentRowMapper());


    }

    public List<CommentImagesDTO> getCommentImage(int reservationInfoId, int reservationCommentId) {
        Map<String, Object> params = new HashMap<String, Object>() {
            {
                put("reservationInfoId", reservationInfoId);
                put("reservationCommentId", reservationCommentId);
            }
        };
        return jdbc.query(SELECT_COMMENT_IMAGE, params, new GetCommentImgRowMapper());
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


    public InsertFileDTO downloadFile(int fileId) {
        Map<String, Integer> params = new HashMap<String, Integer>() {
            {
                put("fileId", fileId);
            }
        };
        return jdbc.queryForObject(SELECT_FILE_INFO, params, new DownloadFile());

    }
}
