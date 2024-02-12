package project3.newfoodfinder.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTests {

    @Autowired
    private MemberService service;

    @Test
    public void testRegister(){
        MemberDTO memberDTO = MemberDTO.builder()
                .userid("Sample userid2..")
                .password("Sample password2..")
                .name("Sample name2..")
                .ssn("Sample ssn2..")
                .phone("Sample phone2..")
                .mail("Sample mail2..")
                .nickname("Sample nickname2..")
                .build();
        System.out.println(service.register(memberDTO));
    }
}
