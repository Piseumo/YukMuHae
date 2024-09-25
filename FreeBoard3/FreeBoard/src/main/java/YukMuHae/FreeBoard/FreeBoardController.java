package YukMuHae.FreeBoard;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//1번 이거 하기
//2번 복합키 넣어보기
//3번 get 처음 화면나오는거 구현
//4번 동현씨꺼 연결해보기
@RestController
@RequiredArgsConstructor
@RequestMapping("freeboard")
public class FreeBoardController {
    private final FreeBoardRepository freeBoardRepository;

    @GetMapping
    public List<FreeBoardResponseDto> getBoardList(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(pageNum,size);
        Page<FreeBoard> page = freeBoardRepository.findAll(pageable);

        List<FreeBoardResponseDto> boardList = new ArrayList<>();
        for (FreeBoard freeBoard : page.getContent()) {
            FreeBoardResponseDto dto = new FreeBoardResponseDto();
            dto.setF_title(freeBoard.getF_title());
            dto.setF_nickname(freeBoard.getF_nickname());
            dto.setF_body(freeBoard.getF_body());

            boardList.add(dto); // 리스트에 추가
        }
        return boardList;
    }

    //전체 게시물 조회 메서드 실패한거 물어보자..생성자가 있어야된데
//    @GetMapping("/listallboard")
//    private ResponseEntity<List<FreeBoardResponseDto>> getAllBoards(
//            @RequestParam(name = "pageNum",defaultValue = "0") int pageNum,
//            @RequestParam(name = "size",defaultValue = "20") int size){
//
//            Pageable pageable = PageRequest.of(pageNum, size);
//            Page<FreeBoard> page = freeBoardRepository.findAll(pageable);
//
//            List<FreeBoardResponseDto> boardList = page.getContent().stream()
//                    .map(FreeBoardResponseDto::new)
//                    .collect(Collectors.toList());
//
//            return ResponseEntity.ok(boardList);
//    }


    // 게시물 작성 메서드
    @PostMapping("/create")
    public ResponseEntity<FreeBoard> createBoard(@Valid @RequestBody FreeBoardReqDto freeBoardReqDto){

        FreeBoard freeBoard = FreeBoard.builder()
                .f_avail(true)
                .f_timestamp(LocalDateTime.now())
                .f_password(freeBoardReqDto.getF_password())
                .f_nickname(freeBoardReqDto.getF_nickname())
                .f_title(freeBoardReqDto.getF_title())
                .f_body(freeBoardReqDto.getF_body())
                        .build();
        freeBoardRepository.save(freeBoard);

        return ResponseEntity.ok(freeBoard);
    }

}
