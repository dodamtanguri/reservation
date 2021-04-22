package kr.or.connect.reservation.service;


import kr.or.connect.reservation.dto.api.PostCommentApiDTO;
import kr.or.connect.reservation.dto.api.CommentApitDTO;

public interface CommentService {

    CommentApitDTO getComment(int productId, int start);
    PostCommentApiDTO insertComments(int reservationInfoId, int score, String comment, int userID);
}
