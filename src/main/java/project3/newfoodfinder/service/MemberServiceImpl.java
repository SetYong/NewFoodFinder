package project3.newfoodfinder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project3.newfoodfinder.dto.MemberFormDTO;
import project3.newfoodfinder.entity.Member;
import project3.newfoodfinder.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public Long join(MemberFormDTO memberFormDTO){
        Member member = Member.builder()
                .mail(memberFormDTO.getMail())
                .username(memberFormDTO.getUsername())
                .userid(memberFormDTO.getUserid())
                .password(memberFormDTO.getPassword())
                .ssn(memberFormDTO.getSsn())
                .phone(memberFormDTO.getPhone())
                .nickname(memberFormDTO.getNickname())
                .build();
        return memberRepository.save(member).getMbnum();
    }

    public Member saveMember(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member){
        Member findMember = memberRepository.findByUserid(member.getUserid());
        if(findMember != null){
            throw new IllegalStateException("이미 사용중인 아이디입니다.");
        }
    }
}
