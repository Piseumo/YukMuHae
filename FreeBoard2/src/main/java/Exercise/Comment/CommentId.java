package Exercise.Comment;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentId implements Serializable {
    private Long f_idx; // FreeBoard의 ID
    private Long c_idx; // Comment의 ID
}
