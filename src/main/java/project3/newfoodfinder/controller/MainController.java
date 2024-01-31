package project3.newfoodfinder.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/MainHeader")
    public String MainHeaderPage(){
        return "/Main/MainHeader";
    }

    @GetMapping("/")
    public String MainPage(){
        return "/Main/MainPage";
    }
}
