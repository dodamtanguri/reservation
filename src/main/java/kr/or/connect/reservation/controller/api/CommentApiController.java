package kr.or.connect.reservation.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.InsertFileDTO;
import kr.or.connect.reservation.dto.api.CommentApiDTO;
import kr.or.connect.reservation.dto.api.PostCommentApiDTO;
import kr.or.connect.reservation.service.CommentService;
import kr.or.connect.reservation.service.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Api(tags = {"댓글목록 API"})
@RestController
@RequestMapping(value = "/api/comments")
@RequiredArgsConstructor
public class CommentApiController {
    private final CommentService commentService;
    @Autowired
    Environment environment;

    @Autowired
    private ServletContext servletContext;

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
            @RequestParam(name = "comment", defaultValue = "댓글을 저장합니다.") String comment,
            @RequestPart(name = "file", required = false) MultipartFile file
    ) throws Exception {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userID = customUserDetails.getUserId();
        return commentService.insertComments(reservationInfoId, score, comment, userID, file);
    }

    @GetMapping(value = "/files/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable(name = "fileId") int fileId) throws IOException {
        InsertFileDTO downloadFile = commentService.downloadFile(fileId);
        File file = new File(environment.getProperty("static.resource.location.img") + "/" + downloadFile.getSaveFileName());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "ㅌno-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Content-Disposition", "attachment; filename=" + file.getName());
        headers.add("Content-Type", "application/octet-stream; charset = utf-8");
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        return ResponseEntity.ok().headers(headers).contentLength(file.length()).body(resource);

    }
}
