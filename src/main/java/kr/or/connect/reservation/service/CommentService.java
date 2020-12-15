package kr.or.connect.reservation.service;

import io.swagger.models.auth.In;
import kr.or.connect.reservation.dto.CommentDTO;
import kr.or.connect.reservation.dto.api.CommentApitDTO;

public interface CommentService {

   public CommentApitDTO getComment(Integer productId);

}
