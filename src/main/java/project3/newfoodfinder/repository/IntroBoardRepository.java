package project3.newfoodfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project3.newfoodfinder.entity.IntroBoard;

public interface IntroBoardRepository extends JpaRepository<IntroBoard, Long> {
}
