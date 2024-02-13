package project3.newfoodfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project3.newfoodfinder.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
