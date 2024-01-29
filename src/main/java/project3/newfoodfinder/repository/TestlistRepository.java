package project3.newfoodfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import project3.newfoodfinder.entity.Testlist;

public interface TestlistRepository extends JpaRepository<Testlist, Long>, QuerydslPredicateExecutor<Testlist> {
}
