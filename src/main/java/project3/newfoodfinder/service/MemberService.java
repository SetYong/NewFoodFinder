package project3.newfoodfinder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project3.newfoodfinder.domain.MemberRequest;
import project3.newfoodfinder.domain.MemberResponse;
import project3.newfoodfinder.mapper.MemberMapper;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;


    public MemberResponse findMemberByLoginId(final String LoginId){
        return memberMapper.findByLoginId(LoginId);
    }

    @Transactional
    public Long deleteMemberById(final Long user_num){
        memberMapper.deleteById(user_num);
        return user_num;
    }

    public int countMemberByLoginId(final String loginId){
        return memberMapper.countByLoginId(loginId);
    }

}
