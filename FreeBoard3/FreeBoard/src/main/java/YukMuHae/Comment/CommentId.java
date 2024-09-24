package YukMuHae.Comment;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommentId implements Serializable {

    private Long c_idx;
    private Long f_idx;
}
