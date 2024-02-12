package project3.newfoodfinder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project3.newfoodfinder.service.FoodService;
import project3.newfoodfinder.service.MemberService;

@Controller
@RequestMapping("/newfoodfinder")
@Log4j2
@RequiredArgsConstructor
public class NewfoodfinderController {

    // home register list
    @GetMapping("/")
    public String index(){
        log.info("home...");
        return "/newfoodfinder/home";
    }


}
