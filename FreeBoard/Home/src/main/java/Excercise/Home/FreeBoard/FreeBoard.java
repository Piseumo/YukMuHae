package Excercise.Home.FreeBoard;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class FreeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long f_idx;

    @Column(nullable = false)
    private Byte f_avail;

    @CreatedDate
    private LocalDateTime f_timestamp;

    @Column(length = 16)
    private String f_password;

    @Column(length = 32)
    private String f_nickname;

    @Column(length = 80)
    private String f_title;

    private String f_body;

}
