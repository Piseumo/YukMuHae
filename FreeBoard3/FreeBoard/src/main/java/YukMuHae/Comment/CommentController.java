package YukMuHae.Comment;

import YukMuHae.FreeBoard.FreeBoardRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentRepository commentRepository;


//    @PostMapping("/builder")
//    public ResponseEntity<Comment> addCommentBuilder(@Valid @RequestBody CommentRequestDto commentRequestDto){
//        FreeBoard freeBoard = freeBoardRepository.findById(commentRequestDto.getF_idx())
//                .orElseThrow(() -> new RuntimeException("해당 게시글이 존재하지 않습니다."));
//        Comment comment = Comment.builder()
//                .f_idx(commentRequestDto.getF_idx())
//                .c_nickname(commentRequestDto.getC_nickname())
//                .c_password(commentRequestDto.getC_password())
//                .c_body(commentRequestDto.getC_body())
//                .c_timestamp(LocalDateTime.now())
//                .freeBoard(freeBoard)
//                .build();
//        commentRepository.save(comment);
//
//        return ResponseEntity.ok(comment);
//    }
@PostMapping //모델매퍼 방싱
public ResponseEntity<Comment> createComment(@Valid @RequestBody CommentRequestDto commentRequestDto) {
    ModelMapper modelMapper = new ModelMapper();
    Comment comment = modelMapper.map(commentRequestDto, Comment.class);

    commentRepository.save(comment);
    return ResponseEntity.ok(comment);
}

}
