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

    @Column(name = "f_avail",nullable = false)
    private Boolean avail = true;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_idx")
    private Long id;

    @CreatedDate
    @Column(name ="f_timestamp",updatable = false)
    private LocalDateTime timestamp;

    @Column(name = "f_password",length = 16,nullable = false)
    private String password;


    @Column(name = "f_nickname",length = 32,nullable = false)
    private String nickname;

    @Column(name = "f_title", length = 80,nullable = false)
    private String title;

    @Column(name ="f_body" ,length = 5000,nullable = false)
    private String body;
}
