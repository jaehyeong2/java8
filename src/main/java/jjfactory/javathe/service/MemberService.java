package jjfactory.javathe.service;

import jjfactory.javathe.model.Member;
import jjfactory.javathe.rep.MemberTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberTestRepository memberRepository;

    @Transactional(readOnly = true)
    public List<Member> getMemberList(){
        List<Member> all = memberRepository.findAll();
        return all;
    }

}
