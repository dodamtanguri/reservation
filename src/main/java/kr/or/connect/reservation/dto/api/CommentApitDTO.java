package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.CommentDTO;

import java.util.List;

public class CommentApitDTO {
    private int totalCount;
    private int commentCount;
    private List<CommentDTO> reservationUserComments;


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public List<CommentDTO> getReservationUserComments() {
        return reservationUserComments;
    }

    public void setReservationUserComments(List<CommentDTO> reservationUserComments) {
        this.reservationUserComments = reservationUserComments;
        this.commentCount = reservationUserComments.size();
    }

    @Override
    public String toString() {
        return "CommentApitDTO{" +
                "totalCount=" + totalCount +
                ", commentCount=" + commentCount +
                ", reservationUserComments=" + reservationUserComments +
                '}';
    }
}
