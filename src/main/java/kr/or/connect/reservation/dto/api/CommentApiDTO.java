package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.CommentDTO;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class CommentApiDTO {
    private int totalCount;
    private int commentCount;
    private List<CommentDTO> reservationUserComments;


    public void setReservationUserComments(List<CommentDTO> reservationUserComments) {
        this.reservationUserComments = reservationUserComments;
        this.commentCount = reservationUserComments.size();
    }

}
