package Exercise.Comment;

import Exercise.FreeBoard.FreeBoard;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@IdClass(CommentId.class)
public class Comment {

    @Id
    @Column(name = "f_idx")
    private Long f_idx;

    @Id
    @Column(name = "c_idx")
    private Long c_idx;

    @Column(name = "c_response_index")
    private Long c_response_index = null;


    @Column(name = "c_avail", nullable = false)
    private Boolean c_avail = true;

    @CreatedDate
    @Column(name = "c_timestamp")
    private LocalDateTime c_timestamp;

    @ManyToOne
    @JoinColumn(name = "f_idx", insertable = false, updatable = false)
    private FreeBoard freeBoard;

    @Column(name = "c_password", length = 16,nullable = false)
    private String c_password;

    @Column(name = "c_nickname", length = 32,nullable = false)
    private String c_nickname;

    @Column(name = "c_body", length = 2000,nullable = false)
    private String c_body;


}
