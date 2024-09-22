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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EntityListeners(AuditingEntityListener.class)
public class Comment {


    @Column(nullable = false)
    private Boolean c_avail;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long c_idx;

    @ManyToOne
    @JoinColumn(name = "c_response_index")
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment")  // 부모 댓글에 달린 대댓글 목록
    private List<Comment> childComments = new ArrayList<>();  // 대댓글들

    @CreatedDate
    private LocalDateTime c_timestamp;

    @ManyToOne
    @JoinColumn(name = "f_idx", nullable = false)
    private FreeBoard freeBoard;

    @Column(length = 16,nullable = false)
    private String c_password;

    @Column(length = 32,nullable = false)
    private String c_nickname;

    @Column(length = 2000,nullable = false)
    private String c_body;


}
