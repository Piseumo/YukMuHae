package Exercise.Comment;

import Exercise.FreeBoard.FreeBoard;
import Exercise.FreeBoard.FreeBoardRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("commentYMH")
@RequiredArgsConstructor
@CrossOrigin
public class CommentController {
    private final CommentRepository commentRepository;
    private final FreeBoardRepository freeBoardRepository;

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments(){
        List<Comment> comments = commentRepository.findAll();
        return ResponseEntity.ok(comments);
    }
    @GetMapping("post/{fidx}/{cidx}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("fidx") Long fidx, @PathVariable("cidx") Long cidx){
        Optional<Comment> comment = commentRepository.findById(new CommentId(fidx,cidx));
        return comment.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@Valid @RequestBody CommentReqDto commentReqDto) {
        ModelMapper modelMapper = new ModelMapper();
        Comment comment = modelMapper.map(commentReqDto, Comment.class);

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
