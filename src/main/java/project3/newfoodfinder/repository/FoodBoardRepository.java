package project3.newfoodfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project3.newfoodfinder.entity.FoodBoard;

public interface FoodBoardRepository extends JpaRepository<FoodBoard, Long> {
}
