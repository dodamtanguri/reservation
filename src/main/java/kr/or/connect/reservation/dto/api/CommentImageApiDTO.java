package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.CommentImagesDTO;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class CommentImageApiDTO {
    private List<CommentImagesDTO> reservationUserCommentImages;

}
