package jjfactory.javathe.controller;

import jjfactory.javathe.rep.MemberTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class SelectController {
    private final MemberTestRepository memberTestRepository;

    @GetMapping("/member")
    public String home(){
        return "home";
    }
}
