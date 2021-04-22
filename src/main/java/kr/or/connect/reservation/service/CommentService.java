package kr.or.connect.reservation.service;


import kr.or.connect.reservation.dto.PostCommentDTO;
import kr.or.connect.reservation.dto.api.CommentApitDTO;

public interface CommentService {

    CommentApitDTO getComment(int productId, int start);
    PostCommentDTO insertComments(int reservationInfoId, int score, String comment, int userID);
}
