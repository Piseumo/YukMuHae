package Exercise.FreeBoard;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EntityListeners(AuditingEntityListener.class)
public class FreeBoard {

    @Column(nullable = false)
    private Boolean f_avail;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long f_idx;

    @CreatedDate
    private LocalDateTime f_timestamp;

    @Column(length = 16,nullable = false)
    private String f_password;

    @Column(length = 32,nullable = false)
    private String f_nickname;

    @Column(length = 80,nullable = false)
    private String f_title;

    @Column(length = 5000,nullable = false)
    private String f_body;
}
