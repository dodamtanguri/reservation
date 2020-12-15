package kr.or.connect.reservation.dto;

public class CommentImagesDTO {
    private int commentImageId;
    private int reservationId;
    private int commentId;
    private int fileId;

    public int getCommentImageId() {
        return commentImageId;
    }

    public void setCommentImageId(int commentImageId) {
        this.commentImageId = commentImageId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return "CommentImagesDTO{" +
                "commentImageId=" + commentImageId +
                ", reservationId=" + reservationId +
                ", commentId=" + commentId +
                ", fileId=" + fileId +
                '}';
    }
}
