package Exercise.Comment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDateTime;

@Data
public class CommentReqDto {

    @NotNull
    private Boolean c_avail;

    private Long c_idx;

    private Long parentCommentId;

    private LocalDateTime c_timestamp;

    @NotNull
    private Long freeBoardId;

    @Length(min = 1,max = 16)
    @NotEmpty
    private String c_password;

    @Length(min = 1, max = 32)
    @NotEmpty
    private String c_nickname;

    @Length(min = 1, max = 2000)
    @NotEmpty
    private String c_body;
}
