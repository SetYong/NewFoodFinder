package project3.newfoodfinder.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project3.newfoodfinder.service.MemberService;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/")
    public String root(){
        return "index";
    }

    // 회원가입 페이지로 이동(get)
    @GetMapping("/newmember")
    public String newmember(){
        return "newmember";
    }

    // 회원가입 DB 전송 (post)
    @PostMapping("/newmember")
    public String newmember(Member member){
        memberService.joinMember(member);
        return "redirect:/newmember";
    }
}
