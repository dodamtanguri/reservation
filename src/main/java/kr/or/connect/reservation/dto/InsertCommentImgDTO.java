package kr.or.connect.reservation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InsertCommentImgDTO {
    private int id;
    private int reservationInfoId;
    private int reservationUserCommentId;
    private int fileId;
    @Builder

    public InsertCommentImgDTO(int id, int reservationInfoId, int reservationUserCommentId, int fileId) {
        this.id = id;
        this.reservationInfoId = reservationInfoId;
        this.reservationUserCommentId = reservationUserCommentId;
        this.fileId = fileId;
    }
}
