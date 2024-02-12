package project3.newfoodfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project3.newfoodfinder.entity.DiaryBoard;

public interface DiaryBoardRepository extends JpaRepository<DiaryBoard, Long> {
}
