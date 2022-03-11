package jjfactory.javathe;

import jjfactory.javathe.model.Member;
import jjfactory.javathe.rep.MemberTestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class RestTest {
    
    private MemberTestRepository memberTestRepository;

    @Test
    void save(){
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setName("lee");
        member2.setName("lee2");
        memberTestRepository.save(member1);
        memberTestRepository.save(member2);

//        List<Member> all = memberTestRepository.findAll();
//        all.stream().collect(Collectors.toList());

        Optional<Member> byId1 = memberTestRepository.findById(1L);
        Optional<Member> byId2 = memberTestRepository.findById(2L);

        System.out.println("byId2 = " + byId2);
        System.out.println("byId1 = " + byId1);
    }
}
