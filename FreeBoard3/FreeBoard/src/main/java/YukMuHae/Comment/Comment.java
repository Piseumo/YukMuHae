package YukMuHae.Comment;

import YukMuHae.FreeBoard.FreeBoard;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@IdClass(CommentId.class)
public class Comment {

    @Id
    private Long c_idx;

    @Id
    private Long f_idx;

    @ManyToOne
    @JoinColumn(name = "f_idx", nullable = false, insertable = false, updatable = false)
    private FreeBoard freeBoard;

    @Column(nullable = false)
    private Boolean c_avail = true;

    private Long c_response_index;

    @Column(length = 32, nullable = false)
    private String c_nickname;

    @Column(length = 16, nullable = false)
    private String c_password;

    @Column(length = 1000, nullable = false)
    private String c_body;

    @CreatedDate
    private LocalDateTime c_timestamp;
}
