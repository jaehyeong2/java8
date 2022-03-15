package jjfactory.book;

import jjfactory.book.model.Member;
import jjfactory.book.model.Order;
import jjfactory.book.repository.MemberRepository;
import jjfactory.book.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional // 테스트 케이스에 있을경우 테스트 끝나면 바로 롤백
public class RepTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void testMember(){
        Member member = new Member();
        member.setName("member1");

        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    void testOrder(){
        Order order = new Order();
        Order savedOrder = orderRepository.save(order);

        Order findOrder = orderRepository.findById(savedOrder.getId()).get();

        Assertions.assertThat(findOrder.getId()).isEqualTo(order.getId());
        Assertions.assertThat(findOrder).isEqualTo(order);
    }


}
