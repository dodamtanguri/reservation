package kr.or.connect.reservation.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.InsertFileDTO;
import kr.or.connect.reservation.dto.api.CommentApitDTO;
import kr.or.connect.reservation.dto.api.PostCommentApiDTO;
import kr.or.connect.reservation.service.CommentService;
import kr.or.connect.reservation.service.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;

@Api(tags = {"댓글목록 API"})
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class CommentApiController {
    private final CommentService commentService;

    @ApiOperation(value = "댓글 목록 구하기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
    @GetMapping(value = "/displayinfos/comment")
    public CommentApitDTO commentApitDTO(
            @RequestParam(name = "START", required = false, defaultValue = "0") int start,
            @RequestParam(name = "productId", required = false, defaultValue = "1") int productId) {
        return commentService.getComment(productId, start);
    }

    @PostMapping(value = "/comments")
    public PostCommentApiDTO postCommentDTO(

            @RequestParam(name = "reservationInfoId", required = true, defaultValue = "17") int reservationInfoId,
            @RequestParam(name = "score", required = true, defaultValue = "3") int score,
            @RequestParam(name = "comment", required = true, defaultValue = "댓글을 저장합니다.") String comment,
            @RequestParam(name = "file") MultipartFile file
    ) throws Exception {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userID = customUserDetails.getUserId();
        InsertFileDTO fileDTO = new InsertFileDTO();

        System.out.println("파일 이름 : " + file.getOriginalFilename());
        System.out.println("파일 크기 : " + file.getSize());

        try (
                FileOutputStream fos = new FileOutputStream("/tmp/" + file.getOriginalFilename());
                InputStream is = file.getInputStream();
        ) {
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while ((readCount = is.read(buffer)) != -1) {
                fos.write(buffer, 0, readCount);
            }
        } catch (Exception ex) {
            throw new RuntimeException("file Save Error");
        }

        return commentService.insertComments(reservationInfoId, score, comment, userID, fileDTO);
    }
}
