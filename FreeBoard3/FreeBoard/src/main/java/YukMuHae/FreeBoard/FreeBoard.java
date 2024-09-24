package YukMuHae.FreeBoard;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
public class FreeBoard {

    private Boolean f_avail = true;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long f_idx;

    @CreatedDate
    private LocalDateTime f_timestamp;

    @Column(length = 16)
    private String f_password;


    @Column(length = 32)
    private String f_nickname;

    @Column(length = 80)
    private String f_title;

    @Column(length = 5000)
    private String f_body;

}
