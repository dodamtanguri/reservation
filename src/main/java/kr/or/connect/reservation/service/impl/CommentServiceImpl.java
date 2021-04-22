package kr.or.connect.reservation.service.impl;

import kr.or.connect.reservation.dao.CommentDAO;
import kr.or.connect.reservation.dto.InsertCommentDTO;
import kr.or.connect.reservation.dto.InsertCommentImgDTO;
import kr.or.connect.reservation.dto.InsertFileDTO;
import kr.or.connect.reservation.dto.PostCommentDTO;
import kr.or.connect.reservation.dto.api.CommentApitDTO;
import kr.or.connect.reservation.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public PostCommentDTO insertComments(int reservationInfoId, int score, String comment, int userID) {
        InsertCommentDTO insert = InsertCommentDTO.builder()
                .userId(userID)
                .comment(comment)
                .reservationInfoId(reservationInfoId)
                .score(score)
                .build();

        int commentId = commentDAO.insertComment(insert);

        InsertFileDTO insertFile = InsertFileDTO.builder()
                .fileName()

        int fileId = commentDAO.insertFile();

        InsertCommentImgDTO insertImg = InsertCommentImgDTO.builder()



        return null;
    }
}
