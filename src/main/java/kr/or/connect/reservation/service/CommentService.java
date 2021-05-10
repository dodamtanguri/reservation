package kr.or.connect.reservation.service;


import kr.or.connect.reservation.dto.InsertFileDTO;
import kr.or.connect.reservation.dto.api.CommentApiDTO;
import kr.or.connect.reservation.dto.api.PostCommentApiDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CommentService {

    CommentApiDTO getComment(int productId, int start, int userId);

    PostCommentApiDTO insertComments(int reservationInfoId, int score, String comment, int userID, MultipartFile file) throws IOException;


    InsertFileDTO downloadFile(int fileId);
}
