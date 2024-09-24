package YukMuHae.FreeBoard;


import lombok.Data;

import java.time.LocalDateTime;
@Data
public class FreeBoardResponseDto {

    private Boolean f_avail;

    private Long f_idx;

    private LocalDateTime f_timestamp;

    private String f_password;
    private String f_nickname;
    private String f_title;

    private String f_body;
}
