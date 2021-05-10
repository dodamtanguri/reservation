package kr.or.connect.reservation.controller.api;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.CommentDTO;
import kr.or.connect.reservation.dto.CommentImagesDTO;
import kr.or.connect.reservation.dto.api.CommentApiDTO;
import kr.or.connect.reservation.service.CommentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@WebAppConfiguration
public class CommentApiControllerTest {

    @InjectMocks
    public CommentApiController controller;

    @Mock
    CommentService commentService;

    private MockMvc mockMvc;

    @Before
    public void createController() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .alwaysExpect(status().isOk())
                .setCustomArgumentResolvers(new AuthenticationPrincipalArgumentResolver())
                .addFilters(new CharacterEncodingFilter("UTF-8", true)).build();
    }


    @Test
    @WithMockCustomUser
    @DisplayName("댓글 조회 하기")
    public void getComment() throws Exception {
        CommentDTO commentDTO = CommentDTO.builder()
                .id(5050)
                .productId(1)
                .reservationInfoId(6060)
                .score(3)
                .comment("댓글 조회 하기 테스트중입니다.")
                .userId(1)
                .build();
        CommentImagesDTO commentImagesDTO = CommentImagesDTO.builder()
                .id(1111)
                .reservationId(6060)
                .reservationUserCommentId(5050)
                .fileId(3333)
                .fileName("FILE NAME")
                .saveFileName("SAVE FILE NAME")
                .contentType("image/png")
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .build();

        List<CommentImagesDTO> ImageList = new ArrayList<>();
        ImageList.add(commentImagesDTO);
        commentDTO.setReservationUserCommentImages(ImageList);

        List<CommentDTO> commentList = new ArrayList<>();
        commentList.add(commentDTO);

        CommentApiDTO comment = new CommentApiDTO();
        comment.setCommentCount(5);
        comment.setTotalCount(5);
        comment.setReservationUserComments(commentList);


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/comments")
                .contentType(MediaType.APPLICATION_JSON);

        when(commentService.getComment(1, 0, 1)).thenReturn(comment);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk()).andDo(print());

        verify(commentService).getComment(1, 0, 1);

    }

}