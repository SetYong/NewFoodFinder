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
import project3.newfoodfinder.dto.ListDTO;
import project3.newfoodfinder.dto.MemberDTO;
import project3.newfoodfinder.dto.PageRequestDTO;
import project3.newfoodfinder.service.MemberService;
import project3.newfoodfinder.service.TestlistService;

@Controller
@RequestMapping("/newfoodfinder")
@Log4j2
@RequiredArgsConstructor
public class NewfoodfinderController {

    private final MemberService service;
    private final TestlistService testlistService;

    @GetMapping("/")
    public String index(){
        log.info("home...");
        return "/newfoodfinder/home";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("list..." + pageRequestDTO);
        model.addAttribute("result", testlistService.getList(pageRequestDTO));
    }

    // get 방식으로 회원가입 화면보여주기
    @GetMapping("/register")
    public void register(){
        log.info("register get...");
    }
    // post 방식으로 회원가입 등록처리
    @PostMapping("/register")
    public String registerPost(MemberDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto....");
        Long mbnum = service.register(dto);
        redirectAttributes.addFlashAttribute("msg", mbnum);
        return "redirect:/newfoodfinder/home";
    }

    //get 방식으로 로그인 화면 보여주기
    @GetMapping("/login")
    public void login(){
        log.info("login get...");
    }
    //post 방식으로 로그인 확인하기
    @PostMapping("/login")
    public boolean loginPost(MemberDTO dto, RedirectAttributes redirectAttributes){
        log.info("login...");
        boolean pass = true;
        return pass;
    }

    //---------------------------------------------------------------------------------
    @GetMapping("/listregister")
    public void listregister(){
        log.info("list register get...");
    }

    @PostMapping("/listregister")
    public String listregisterPost(ListDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto..."+dto);
        Long listno = testlistService.register(dto);
        redirectAttributes.addFlashAttribute("msg", listno);
        return "redirect:/newfoodfinder/list";
    }

    @GetMapping({"/read","/modify"})
    public void read(long listno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){
        log.info("listno: " + listno);
        ListDTO dto = testlistService.read(listno);
        model.addAttribute("dto", dto);
    }

    @PostMapping("/remove")
    public String remove(long listno, RedirectAttributes redirectAttributes){
        log.info("listno: "+listno);
        testlistService.remove(listno);
        redirectAttributes.addFlashAttribute("msg", listno);
        return "redirect:/newfoodfinder/list";
    }

    @PostMapping("/modify")
    public String modify(ListDTO dto, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, RedirectAttributes redirectAttributes){
        log.info("post modify...");
        log.info("dto: "+ dto);
        testlistService.modify(dto);
        redirectAttributes.addAttribute("page",requestDTO.getPage());
        redirectAttributes.addAttribute("type",requestDTO.getType());
        redirectAttributes.addAttribute("keyword",requestDTO.getKeyword());
        redirectAttributes.addAttribute("listno",dto.getListno());
        return "redirect:/newfoodfinder/read";
    }
}
