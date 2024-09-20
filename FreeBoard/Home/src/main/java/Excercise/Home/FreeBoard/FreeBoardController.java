package Excercise.Home.FreeBoard;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("freeboard")
@RequiredArgsConstructor
@CrossOrigin

public class FreeBoardController {
    private final FreeBoardRepository freeBoardRepository;

    @GetMapping
    public List<FreeBoard> getAllposts() {
        return freeBoardRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<FreeBoard> createPost(@RequestBody FreeBoardReqDto freeBoardReqDto) {
        // DTO를 엔티티로 변환 (간단한 예시로 변환 로직 추가 가능)
        FreeBoard newPost = FreeBoard.builder()
                .f_title(freeBoardReqDto.getF_title())
                .f_body(freeBoardReqDto.getF_body())
                .f_nickname(freeBoardReqDto.getF_nickname())
                .f_password(freeBoardReqDto.getF_password())
                .f_timestamp(LocalDateTime.now()) // 현재 시간을 저장
                .build();
        // 게시글을 데이터베이스에 저장
        FreeBoard savedPost = freeBoardRepository.save(newPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }
}
