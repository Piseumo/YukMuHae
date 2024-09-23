package Exercise.FreeBoard;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDateTime;

@Data
public class FreeBoardReqDto {

//    @NotNull
    private Boolean f_avail;

    private Long f_idx;

    private LocalDateTime f_timestamp;

    @Length(min = 1, max = 16)
    @NotEmpty(message = "비밀번호는 반드시 입력해야합니다")
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
