package kr.or.connect.reservation.dto.api;

import kr.or.connect.reservation.dto.CommentImagesDTO;

import java.util.List;

public class CommentImageApiDTO {
    private List<CommentImagesDTO> reservationUserCommentImages;

    public List<CommentImagesDTO> getReservationUserCommentImages() {
        return reservationUserCommentImages;
    }

    public void setReservationUserCommentImages(List<CommentImagesDTO> reservationUserCommentImages) {
        this.reservationUserCommentImages = reservationUserCommentImages;
    }

    @Override
    public String toString() {
        return "CommentImageApiDTO{" +
                "reservationUserCommentImages=" + reservationUserCommentImages +
                '}';
    }
}
