package Excercise.Home.FreeBoard;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDateTime;

@Data
@Getter
public class FreeBoardReqDto {

    private Long f_idx;

    private Byte f_avail;

    private LocalDateTime f_timestamp;

    @Length(min = 1, max = 16)
    @NotEmpty
    private String f_password;

    @Length(min = 1, max = 32)
    @NotEmpty
    private String f_nickname;

    @Length(min = 1, max = 80)
    @NotEmpty
    private String f_title;

    @Length(min = 1, max = 5000)
    @NotEmpty
    private String f_body;

}
