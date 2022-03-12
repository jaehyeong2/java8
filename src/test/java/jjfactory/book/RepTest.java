package jjfactory.book;

import jjfactory.book.model.Member;
import jjfactory.book.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class RepTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional // 테스트 케이스에 있을경우 테스트 끝나면 바로 롤백
    void testMember(){
        Member member = new Member();
        member.setName("member1");

        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
    }
}
