package YukMuHae.FreeBoard;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//1번 이거 하기
//2번 복합키 넣어보기
//3번 get 처음 화면나오는거 구현
//4번 동현씨꺼 연결해보기
@RestController
@AllArgsConstructor
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
            dto.setF_idx(freeBoard.getF_idx());
            dto.setF_title(freeBoard.getF_title());
            dto.setF_nickname(freeBoard.getF_nickname());
            dto.setF_body(freeBoard.getF_body());
            dto.setF_avail(freeBoard.getF_avail());

            boardList.add(dto); // 리스트에 추가
        }
        return boardList;
    }

    @PostMapping
    public ResponseEntity<FreeBoard> insert(@Valid @RequestBody FreeBoardReqDto freeBoardReqDto){
        FreeBoard freeBoard = new FreeBoard();
            freeBoard.setF_avail(freeBoardReqDto.getF_avail());
            freeBoard.setF_idx(freeBoardReqDto.getF_idx());
            freeBoard.setF_title(freeBoardReqDto.getF_title());
            freeBoard.setF_nickname(freeBoardReqDto.getF_nickname());
            freeBoard.setF_password(freeBoardReqDto.getF_password());
            freeBoard.setF_body(freeBoardReqDto.getF_body());
            freeBoardRepository.save(freeBoard);
        return ResponseEntity.ok(freeBoard);
    }

}
