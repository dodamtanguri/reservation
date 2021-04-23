package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.CommentDAO;
import kr.or.connect.reservation.dto.InsertCommentDTO;
import kr.or.connect.reservation.dto.InsertCommentImgDTO;
import kr.or.connect.reservation.dto.InsertFileDTO;
import kr.or.connect.reservation.dto.api.CommentApitDTO;
import kr.or.connect.reservation.dto.api.PostCommentApiDTO;
import kr.or.connect.reservation.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDAO commentDAO;

    @Override
    @Transactional(readOnly = true)
    public CommentApitDTO getComment(int productId, int start) {
        CommentApitDTO commentApitDTO = new CommentApitDTO();
        commentApitDTO.setReservationUserComments(commentDAO.getComment(productId, start));
        commentApitDTO.setTotalCount(commentDAO.getTotalCount(productId));
        return commentApitDTO;

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

        InsertFileDTO fileDTO = new InsertFileDTO();
        fileDTO.setFileName(file.getOriginalFilename());
        fileDTO.setSaveFileName(file.getOriginalFilename());
        fileDTO.setContentType(file.getContentType());


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
