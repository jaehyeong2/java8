package jjfactory.javathe.controller;

import jjfactory.javathe.rep.MemberTestRepository;
import jjfactory.javathe.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class SelectController {
    private final MemberService memberService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/member")
    public String selectMember(Model model){
        model.addAttribute("members",memberService.getMemberList());
        return "member";
    }
}
