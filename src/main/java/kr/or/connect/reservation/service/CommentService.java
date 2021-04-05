package kr.or.connect.reservation.service;


import kr.or.connect.reservation.dto.api.CommentApitDTO;

public interface CommentService {

     CommentApitDTO getComment(int productId, int start);

}
