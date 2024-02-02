package project3.newfoodfinder.service;

import project3.newfoodfinder.dto.MemberFormDTO;
import project3.newfoodfinder.entity.Member;

public interface MemberService {
    Long join(MemberFormDTO memberFormDTO);
    Member saveMember(Member member);
}
