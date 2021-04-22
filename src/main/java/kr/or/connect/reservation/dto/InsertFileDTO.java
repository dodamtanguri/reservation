package kr.or.connect.reservation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class InsertFileDTO {
    private int id;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private int deleteFlag;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    @Builder

    public InsertFileDTO(int id, String fileName, String saveFileName, String contentType, int deleteFlag, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.id = id;
        this.fileName = fileName;
        this.saveFileName = saveFileName;
        this.contentType = contentType;
        this.deleteFlag = deleteFlag;
        this.createDate = LocalDateTime.now();
        this.modifyDate = LocalDateTime.now();
    }
}
