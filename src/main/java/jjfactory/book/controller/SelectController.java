package jjfactory.book.controller;

import jjfactory.book.model.Member;
import jjfactory.book.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/member")
    public ResponseEntity<?> postMember(Member member){
        memberService.memberSave(member);
        return new ResponseEntity<>("GOOD",HttpStatus.OK);
    }
}
