package YukMuHae.Comment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CommentRequestDto {

    @NotNull
    private Long f_idx;

    private Boolean c_avail = true;

    private Long c_response_index;

    @NotEmpty
    @Length(min= 1, max = 32)
    private String c_nickname;

    @NotEmpty
    @Length(min= 1, max = 16)
    private String c_password;

    @NotEmpty
    @Length(min= 1, max = 1000)
    private String c_body;


}
