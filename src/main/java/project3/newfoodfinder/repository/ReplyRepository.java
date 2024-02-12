package project3.newfoodfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project3.newfoodfinder.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
