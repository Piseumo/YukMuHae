package Exercise.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment , CommentId> {

}
// jpa는 엔티티 밖에 모르는 바보다.