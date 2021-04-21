package kr.or.connect.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class InsertCommentDTO {
    private int id;
    private int productId;
    private int reservationInfoId;
    private int score;
    private String comment;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDateTime createDate;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDateTime modifyDate;

    @Builder

    public InsertCommentDTO(int id, int productId, int reservationInfoId, int score, String comment, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.id = id;
        this.productId = productId;
        this.reservationInfoId = reservationInfoId;
        this.score = score;
        this.comment = comment;
        this.createDate = LocalDateTime.now();
        this.modifyDate = LocalDateTime.now();
    }
}
