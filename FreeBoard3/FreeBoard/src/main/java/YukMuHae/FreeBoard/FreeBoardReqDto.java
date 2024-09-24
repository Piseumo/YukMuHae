package YukMuHae.FreeBoard;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
public class FreeBoardReqDto {

    private Boolean f_avail;

    private Long f_idx;

    private LocalDateTime f_timestamp;

    @NotNull
    @Length(min = 1 , max =16)
    private String f_password;

    @NotNull
    @Length(min = 1 , max = 32)
    private String f_nickname;

    @NotNull
    @Length(min = 1 ,max= 80)
    private String f_title;

    @NotNull
    @Length(min = 1, max = 5000)
    private String f_body;


}
