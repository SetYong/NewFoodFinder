package project3.newfoodfinder.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project3.newfoodfinder.entity.Member;


import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertDummies(){
        IntStream.rangeClosed(1,10).forEach(i ->{
            Member member = Member.builder()
                    .name("name test" + i)
                    .userid("userid test"+i)
                    .password("password test"+i)
                    .ssn("ssn test"+i)
                    .mail("mail test"+i)
                    .phone("phone test"+i)
                    .nickname("nickname test"+i)
                    .build();
            System.out.println(memberRepository.save(member));
        });
    }

    @Test
    public void updateTest(){
        Optional<Member> result = memberRepository.findById(1L);
        if(result.isPresent()){
            Member member = result.get();
            member.changeName("change test name");
            member.changeMail("change test mail");
            member.changePhone("change test phone");
            member.changePassword("change test password");
            member.changeNickname("change test nickname");
            memberRepository.save(member);
        }
    }

}
