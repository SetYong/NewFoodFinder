package project3.newfoodfinder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project3.newfoodfinder.service.MemberService;

@Controller
@RequestMapping("/newfoodfinder")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    //get 방식으로 로그인 화면 보여주기
    @GetMapping("/login")
    public void login(){
        log.info("login get...");
    }

}
