package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.CommentDAO;
import kr.or.connect.reservation.dto.*;
import kr.or.connect.reservation.dto.api.CommentApiDTO;
import kr.or.connect.reservation.dto.api.PostCommentApiDTO;
import kr.or.connect.reservation.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDAO commentDAO;

    @Override
    @Transactional(readOnly = true)
    public CommentApiDTO getComment(int productId, int start, int userId) {

        List<CommentDTO> commentList = commentDAO.getCommentList(productId, start, userId);
        for (int i = 0; i < 5; i++) {
            int reservationInfoId = commentList.get(i).getReservationInfoId();
            int reservationCommentId = commentList.get(i).getId();
            List<CommentImagesDTO> commentImage = commentDAO.getCommentImage(reservationInfoId, reservationCommentId);
            if (commentImage != null)
                commentList.get(i).setReservationUserCommentImages(commentImage);
        }

        CommentApiDTO commentApiDTO = new CommentApiDTO();
        commentApiDTO.setReservationUserComments(commentList);
        commentApiDTO.setTotalCount(commentDAO.getTotalCount(productId));
        return commentApiDTO;

    }


    @Override
    public PostCommentApiDTO insertComments(int reservationInfoId, int score, String comment, int userID, MultipartFile file) {
        int productId = commentDAO.getProductId(reservationInfoId, userID);

        InsertCommentDTO insert = InsertCommentDTO.builder()
                .productId(productId)
                .userId(userID)
                .comment(comment)
                .reservationInfoId(reservationInfoId)
                .score(score)
                .build();

        int commentId = commentDAO.insertComment(insert);
        if(file != null) {
            InsertFileDTO fileDTO = new InsertFileDTO();
            fileDTO.setFileName(file.getOriginalFilename());
            fileDTO.setSaveFileName(file.getOriginalFilename());
            fileDTO.setContentType(file.getContentType());
        } else {
            
        }



        int fileId = commentDAO.insertCommentFile(fileDTO);

        InsertCommentImgDTO insertImg = InsertCommentImgDTO.builder()
                .reservationInfoId(reservationInfoId)
                .reservationUserCommentId(commentId)
                .fileId(fileId)
                .build();
        int status = commentDAO.insertCommentImg(insertImg);
        PostCommentApiDTO commentApi = new PostCommentApiDTO();
        commentApi.setProductId(productId);
        commentApi.setResult(status == 0 ? "fail" : "Success");
        return commentApi;
    }
}
