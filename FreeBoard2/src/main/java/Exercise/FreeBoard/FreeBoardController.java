package Exercise.FreeBoard;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("freeboardYMH")
@RequiredArgsConstructor
@CrossOrigin
public class FreeBoardController {
    private final FreeBoardRepository freeBoardRepository;

    @GetMapping
    public ResponseEntity<List<FreeBoard>> getAllFreeBoards(){
        List<FreeBoard> freeBoards = freeBoardRepository.findAll();
        return ResponseEntity.ok(freeBoards);
    }
    @GetMapping("post/{id}")
    public ResponseEntity<FreeBoard> getFreeBoardById(@PathVariable("id") Long id){
        Optional<FreeBoard> freeBoard = freeBoardRepository.findById(id);
        return freeBoard.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FreeBoard> createFreeBoard(@Valid @RequestBody FreeBoardReqDto freeBoardReqDto){
        FreeBoard freeBoard = FreeBoard.builder()
                .avail(true)
                .password(freeBoardReqDto.getF_password())
                .nickname(freeBoardReqDto.getF_nickname())
                .title(freeBoardReqDto.getF_title())
                .body(freeBoardReqDto.getF_body())
                .timestamp(freeBoardReqDto.getF_timestamp())
                .build();

        freeBoardRepository.save(freeBoard);
        return ResponseEntity.ok(freeBoard);
    }

}
