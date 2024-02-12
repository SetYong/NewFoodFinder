package project3.newfoodfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project3.newfoodfinder.entity.QuestionBoard;

public interface QuestionBoardRepository extends JpaRepository<QuestionBoard, Long> {
}
