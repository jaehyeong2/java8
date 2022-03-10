package jjfactory.javathe.api;

import jjfactory.javathe.model.Member;
import jjfactory.javathe.rep.MemberTestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyApiController {

    private final MemberTestRepository memberTestRepository;

    public MyApiController(MemberTestRepository memberTestRepository) {
        this.memberTestRepository = memberTestRepository;
    }

    @PostMapping("/member")
    public ResponseEntity<?> memberSave(Member member, @RequestParam String name){
        memberTestRepository.save(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
