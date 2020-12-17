package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class CommentDTO {
    private int id;
    private int productId;
    private int reservationInfoId;
    private int score;
    private String reservationEmail;
    private String comment;
    private String createDate;
    private String modifyDate;
    private List<CommentImagesDTO> reservationUserCommentImages;

}
