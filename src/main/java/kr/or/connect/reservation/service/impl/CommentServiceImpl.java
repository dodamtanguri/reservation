package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.CommentDAO;
import kr.or.connect.reservation.dto.*;
import kr.or.connect.reservation.dto.api.CommentApiDTO;
import kr.or.connect.reservation.dto.api.PostCommentApiDTO;
import kr.or.connect.reservation.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDAO commentDAO;

    @Autowired
    Environment environment;

    @Override
    @Transactional(readOnly = true)
    public CommentApiDTO getComment(int productId, int start, int userId) {

        List<CommentDTO> commentList = commentDAO.getCommentList(productId, start, userId);
        for (CommentDTO comment : commentList) {
            int reservationInfoId = comment.getReservationInfoId();
            int reservationCommentId = comment.getId();
            List<CommentImagesDTO> commentImage = commentDAO.getCommentImage(reservationInfoId, reservationCommentId);
            comment.setReservationUserCommentImages(commentImage);
        }

        CommentApiDTO commentApiDTO = new CommentApiDTO();
        commentApiDTO.setReservationUserComments(commentList);
        commentApiDTO.setTotalCount(commentDAO.getTotalCount(productId));
        return commentApiDTO;

    }


    @Override
    public PostCommentApiDTO insertComments(int reservationInfoId, int score, String comment, int userID, MultipartFile file) throws IOException {
        PostCommentApiDTO commentApi = new PostCommentApiDTO();
        if (file.isEmpty()) {
            commentApi.setResult("fail");
            commentApi.setProductId(0);
        } else {
            int productId = commentDAO.getProductId(reservationInfoId, userID);

            InsertCommentDTO insert = InsertCommentDTO.builder()
                    .productId(productId)
                    .userId(userID)
                    .comment(comment)
                    .reservationInfoId(reservationInfoId)
                    .score(score)
                    .build();
            int commentId = commentDAO.insertComment(insert);


            InsertFileDTO fileDTO = new InsertFileDTO();

            String saveName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            fileDTO.setFileName(file.getOriginalFilename());
            fileDTO.setSaveFileName(saveName);
            fileDTO.setContentType(file.getContentType());

            File target = new File(environment.getProperty("static.resource.location.img"), saveName);
            FileCopyUtils.copy(file.getBytes(), target);

            int fileId = commentDAO.insertCommentFile(fileDTO);

            InsertCommentImgDTO insertImg = InsertCommentImgDTO.builder()
                    .reservationInfoId(reservationInfoId)
                    .reservationUserCommentId(commentId)
                    .fileId(fileId)
                    .build();
            int status = commentDAO.insertCommentImg(insertImg);

            commentApi.setProductId(productId);
            commentApi.setResult(status == 0 ? "fail" : "Success");


        }
        return commentApi;
    }

    @Override
    public InsertFileDTO downloadFile(int fileId) {
        return commentDAO.downloadFile(fileId);
    }
}
