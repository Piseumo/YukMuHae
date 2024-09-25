package YukMuHae.FreeBoard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Data
public class FreeBoardResponseDto {
    private LocalDateTime f_timestamp;
    private String f_nickname;
    private String f_title;
    private String f_body;

}
