package kr.or.connect.reservation.service;


import kr.or.connect.reservation.dto.InsertFileDTO;
import kr.or.connect.reservation.dto.api.CommentApitDTO;
import kr.or.connect.reservation.dto.api.PostCommentApiDTO;

public interface CommentService {

    CommentApitDTO getComment(int productId, int start);
    PostCommentApiDTO insertComments(int reservationInfoId, int score, String comment, int userID, InsertFileDTO fileDTO);
}
