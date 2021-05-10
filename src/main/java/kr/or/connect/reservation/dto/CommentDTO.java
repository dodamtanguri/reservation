package kr.or.connect.reservation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
    private int id;
    private int productId;
    private int reservationInfoId;
    private int score;
    private int userId;
    private String comment;
    private List<CommentImagesDTO> reservationUserCommentImages;

    @Builder
    public CommentDTO(int id, int productId, int reservationInfoId, int score, int userId, String comment) {
        this.id = id;
        this.productId = productId;
        this.reservationInfoId = reservationInfoId;
        this.score = score;
        this.userId = userId;
        this.comment = comment;
    }

    public CommentDTO(int id, int productId, int reservationInfoId, int score, int userId, String comment, List<CommentImagesDTO> reservationUserCommentImages) {
        this.id = id;
        this.productId = productId;
        this.reservationInfoId = reservationInfoId;
        this.score = score;
        this.userId = userId;
        this.comment = comment;
        this.reservationUserCommentImages = reservationUserCommentImages;
    }
}
