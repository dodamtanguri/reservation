package kr.or.connect.reservation.controller.api;

import kr.or.connect.reservation.dto.CommentDTO;
import kr.or.connect.reservation.dto.CommentImagesDTO;
import kr.or.connect.reservation.dto.api.CommentApitDTO;
import kr.or.connect.reservation.service.CommentService;
import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Arrays;

import java.util.List;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
public class CommentApiControllerTest {
    @InjectMocks
    public CommentApiController commentApiController;
    @Mock
    CommentService commentService;
    private MockMvc mockMvc;

    @Before
    public void createController() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(commentApiController).addFilters(new CharacterEncodingFilter("UTF-8", true)).build();
    }

    @Test
    public void getCommentImgae() throws Exception {

        CommentImagesDTO imagesDTO = new CommentImagesDTO();
        imagesDTO.setCommentImageId(1111);
        imagesDTO.setReservationId(6060);
        imagesDTO.setCommentId(5050);
        imagesDTO.setFileId(7070);
        List<CommentImagesDTO> imagesDTOList = Arrays.asList(imagesDTO);
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setReservationUserCommentImages(imagesDTOList);

        CommentDTO dto = new CommentDTO();
        dto.setId(5050);
        dto.setProductId(1010);
        dto.setReservationInfoId(6060);
        dto.setScore(4);
        dto.setReservationUserCommentImages(imagesDTOList);
        dto.setReservationEmail("email");
        dto.setComment("최고!");
        dto.setCreateDate("등록일");
        dto.setModifyDate("수정일");

        List<CommentDTO> commentDTOS = Arrays.asList(dto);
        CommentApitDTO commentApitDTO = new CommentApitDTO();
        commentApitDTO.setReservationUserComments(commentDTOS);
        commentApitDTO.setCommentCount(15);
        commentApitDTO.setTotalCount(5);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/displayinfos/comment").contentType(MediaType.APPLICATION_JSON);
        when(commentService.getComment(1, 0)).thenReturn(commentApitDTO);


        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
        verify(commentService).getComment(1, 0);


    }

}