package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentImagesDTO {
    private int commentImageId;
    private int reservationId;
    private int commentId;
    private int fileId;

}
