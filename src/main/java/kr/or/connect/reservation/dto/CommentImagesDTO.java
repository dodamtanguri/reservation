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
public class CommentImagesDTO {
    private int id;
    private int reservationId;
    private int reservationUserCommentId;
    private int fileId;
    private String fileName;
    private String saveFileName;
    private String contentType;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDateTime createDate;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDateTime modifyDate;


    @Builder

    public CommentImagesDTO(int id, int reservationId, int reservationUserCommentId, int fileId, String fileName, String saveFileName, String contentType, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.id = id;
        this.reservationId = reservationId;
        this.reservationUserCommentId = reservationUserCommentId;
        this.fileId = fileId;
        this.fileName = fileName;
        this.saveFileName = saveFileName;
        this.contentType = contentType;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }
}
