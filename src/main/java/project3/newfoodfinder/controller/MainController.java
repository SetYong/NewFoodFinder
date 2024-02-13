package project3.newfoodfinder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project3.newfoodfinder.dto.FoodBoardDTO;
import project3.newfoodfinder.dto.PageRequestDTO;
import project3.newfoodfinder.service.FoodService;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MainController {
    private final FoodService foodService;

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/foodboard")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("list........" + pageRequestDTO);
        model.addAttribute("result",foodService.getList(pageRequestDTO));
    }
    @GetMapping("/register")
    public void register(){
        log.info("register...");
    }
    @PostMapping("/register")
    public String registerPost(FoodBoardDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto..." + dto);
        Long gno = foodService.register(dto);
        redirectAttributes.addFlashAttribute("msg", gno);
        return "redirect:/guestbook/list";
    }

    //@GetMapping("/read")
    @GetMapping({"/read", "/modify"})
    public void read(long gno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){
        log.info("gno: " + gno);
        FoodBoardDTO dto = foodService.read(gno);
        model.addAttribute("dto", dto);
    }

    @PostMapping("/remove")
    public String remove(long gno, RedirectAttributes redirectAttributes){
        log.info("gno: "+ gno);
        foodService.remove(gno);
        redirectAttributes.addFlashAttribute("msg", gno);
        return "redirect:/guestbook/list";
    }

    @PostMapping("/modify")
    public String modify(FoodBoardDTO dto, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, RedirectAttributes redirectAttributes){
        log.info("post modify................................");
        log.info("dto: " + dto);
        foodService.modify(dto);
        redirectAttributes.addAttribute("page", requestDTO.getPage());
        redirectAttributes.addAttribute("type", requestDTO.getType());
        redirectAttributes.addAttribute("keyword", requestDTO.getKeyword());
        redirectAttributes.addAttribute("headnum", dto.getHeadnum());
        return "redirect:/read";
    }
}
