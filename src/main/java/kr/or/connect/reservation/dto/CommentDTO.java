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

//    @Builder
//
//    public CommentDTO(int id, int productId, int reservationInfoId, int score, String reservationEmail, String comment, String createDate, String modifyDate, List<CommentImagesDTO> reservationUserCommentImages) {
//        this.id = id;
//        this.productId = productId;
//        this.reservationInfoId = reservationInfoId;
//        this.score = score;
//        this.reservationEmail = reservationEmail;
//        this.comment = comment;
//        this.createDate = createDate;
//        this.modifyDate = modifyDate;
//        this.reservationUserCommentImages = reservationUserCommentImages;
//    }
}
