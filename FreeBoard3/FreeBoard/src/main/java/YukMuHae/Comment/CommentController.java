package YukMuHae.Comment;

import YukMuHae.FreeBoard.FreeBoard;
import YukMuHae.FreeBoard.FreeBoardRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentRepository commentRepository;
    private final FreeBoardRepository freeBoardRepository;

//    @PostMapping("/addcomment")
//    public ResponseEntity<String> addComment(@Valid @RequestBody CommentRequestDto commentRequestDto){
//        FreeBoard freeBoard = freeBoardRepository.findById(commentRequestDto.getF_idx())
//                .orElseThrow(() -> new RuntimeException("게시물을 찾을 수 없습니다."));
//        Comment comment = new Comment();
//        comment.setFreeBoard(freeBoard);
//        comment.setC_avail(commentRequestDto.getC_avail());
//        comment.setC_response_index(commentRequestDto.getC_response_index());
//        comment.setC_password(commentRequestDto.getC_password());
//        comment.setC_nickname(commentRequestDto.getC_nickname());
//        comment.setC_body(commentRequestDto.getC_body());
//        comment.setC_timestamp(LocalDateTime.now());
//
//        commentRepository.save(comment);
//        return ResponseEntity.ok("ok");
//
//    }

//    @PostMapping("/builder")
//    public ResponseEntity<String> addCommentBuilder(@Valid @RequestBody CommentRequestDto commentRequestDto){
//        FreeBoard freeBoard = freeBoardRepository.findById(commentRequestDto.getF_idx())
//                .orElseThrow(()-> new RuntimeException("게시물을 찾을 수 없습니다"));
//        Comment comment = Comment.builder()
//                .freeBoard(freeBoard)
//                .c_avail(commentRequestDto.getC_avail())
//                .c_response_index(commentRequestDto.getC_response_index())
//                .c_password(commentRequestDto.getC_password())
//                .c_nickname(commentRequestDto.getC_nickname())
//                .c_body(commentRequestDto.getC_body())
//                .c_timestamp(LocalDateTime.now())
//                .build();
//        commentRepository.save(comment);
//
//        return ResponseEntity.ok("ok");
//    }
@PostMapping
public ResponseEntity<Comment> createComment(@Valid @RequestBody CommentRequestDto commentRequestDto) {
    ModelMapper modelMapper = new ModelMapper();
    Comment comment = modelMapper.map(commentRequestDto, Comment.class);

//        Comment comment = Comment.builder()
//                .avail(true)
//                .password(commentReqDto.getC_password())
//                .nickname(commentReqDto.getC_nickname())
//                .body(commentReqDto.getC_body())
//                .timestamp(commentReqDto.getC_timestamp())
//                .freeBoard(freeBoard)
//                .build();

    commentRepository.save(comment);
    return ResponseEntity.ok(comment);
}

}
