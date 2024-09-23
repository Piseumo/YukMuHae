package Exercise.Comment;

import Exercise.FreeBoard.FreeBoard;
import Exercise.FreeBoard.FreeBoardRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    @GetMapping("post/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") Long id){
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@Valid @RequestBody CommentReqDto commentReqDto) {
        FreeBoard freeBoard = freeBoardRepository.findById(commentReqDto.getFreeBoardId())
                .orElseThrow(() -> new RuntimeException("FreeBoard not found"));

        Comment comment = Comment.builder()
                .c_avail(true)
                .c_password(commentReqDto.getC_password())
                .c_nickname(commentReqDto.getC_nickname())
                .c_body(commentReqDto.getC_body())
                .c_timestamp(commentReqDto.getC_timestamp())
                .freeBoard(freeBoard)
                .build();

        commentRepository.save(comment);
        return ResponseEntity.ok(comment);
    }
}
