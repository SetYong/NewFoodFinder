package project3.newfoodfinder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project3.newfoodfinder.dto.PageRequestDTO;
import project3.newfoodfinder.service.FoodService;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MainController {
    private final FoodService foodService;

    @GetMapping(value = "/")
    public String main() {
        return "main";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("list........" + pageRequestDTO);
        model.addAttribute("result",foodService.getList(pageRequestDTO));
    }
}
