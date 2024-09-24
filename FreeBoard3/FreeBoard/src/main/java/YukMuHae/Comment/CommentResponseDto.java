package YukMuHae.Comment;

import YukMuHae.FreeBoard.FreeBoard;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CommentResponseDto {

    private Long c_idx;

    private Long f_idx;

    private FreeBoard freeBoard;

    private Boolean c_avail = true;

    private Long c_response_index;

    private String c_nickname;

    private String c_password;

    private String c_body;

    private LocalDateTime c_timestamp;
}
