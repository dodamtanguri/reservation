package kr.or.connect.reservation.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.api.CommentApiDTO;
import kr.or.connect.reservation.dto.api.PostCommentApiDTO;
import kr.or.connect.reservation.service.CommentService;
import kr.or.connect.reservation.service.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = {"댓글목록 API"})
@RestController
@RequestMapping(value = "/api/comments")
@RequiredArgsConstructor
public class CommentApiController {
    private final CommentService commentService;

    @ApiOperation(value = "댓글 목록 구하기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
    @GetMapping
    public CommentApiDTO commentApiDTO(
            @RequestParam(name = "START", required = false, defaultValue = "0") int start,
            @RequestParam(name = "productId", required = false, defaultValue = "1") int productId) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userID = customUserDetails.getUserId();
        return commentService.getComment(productId, start, userID);
    }

    @PostMapping
    public PostCommentApiDTO addCommentDTO(
            @RequestParam(name = "reservationInfoId", required = true, defaultValue = "1") int reservationInfoId,
            @RequestParam(name = "score", required = true, defaultValue = "3") int score,
            @RequestParam(name = "comment", required = true, defaultValue = "댓글을 저장합니다.") String comment,
            @RequestParam(name = "file") MultipartFile file
    ) throws Exception {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userID = customUserDetails.getUserId();
        return commentService.insertComments(reservationInfoId, score, comment, userID, file);
    }
}
