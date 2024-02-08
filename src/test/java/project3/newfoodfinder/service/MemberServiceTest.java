package project3.newfoodfinder.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import project3.newfoodfinder.dto.MemberFormDTO;
import project3.newfoodfinder.entity.Member;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml"})
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember(){
        MemberFormDTO memberFormDTO = MemberFormDTO.builder()
                .username("security test name")
                .userid("security test id")
                .password("security test pass")
                .ssn("security test")
                .mail("security test")
                .phone("security test")
                .nickname("security test")
                .address("security test")
                .build();
        return Member.createMember(memberFormDTO, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest(){
        Member member = createMember();
        Member savedMember = memberService.saveMember(member);
        assertEquals(member.getUserid(), savedMember.getUserid());
    }

}
