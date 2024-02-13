package project3.newfoodfinder.mapper;

import project3.newfoodfinder.domain.MemberRequest;
import project3.newfoodfinder.domain.MemberResponse;


public interface MemberMapper {

    void save(MemberRequest params);
    MemberResponse findByLoginId(String loginId);
    void update(MemberRequest params);
    void deleteById(Long user_num);
    int countByLoginId(String loginId);

}