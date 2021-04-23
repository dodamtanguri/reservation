package kr.or.connect.reservation.service;


import kr.or.connect.reservation.dto.api.CommentApitDTO;
import kr.or.connect.reservation.dto.api.PostCommentApiDTO;
import org.springframework.web.multipart.MultipartFile;

public interface CommentService {

    CommentApitDTO getComment(int productId, int start);
    PostCommentApiDTO insertComments(int reservationInfoId, int score, String comment, int userID, MultipartFile file);
}
