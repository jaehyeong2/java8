package jjfactory.book.service;

import jjfactory.book.model.Member;
import jjfactory.book.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<Member> getMemberList() {
        List<Member> all = memberRepository.findAll();
        return all;
    }

    @Transactional
    public void memberSave(Member member){
        memberRepository.save(member);
    }
}
