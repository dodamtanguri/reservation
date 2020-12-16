package kr.or.connect.reservation.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.api.CommentApitDTO;
import kr.or.connect.reservation.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

            @RequestParam(name = "productId", required = false, defaultValue = "1") int productId) {
        return commentService.getComment(productId);
    }
}
