package jjfactory.book.service;

import jjfactory.book.enums.OrderStatus;
import jjfactory.book.model.Member;
import jjfactory.book.model.Order;
import jjfactory.book.repository.MemberRepository;
import jjfactory.book.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<Order> getMemberList() {
        List<Order> all = orderRepository.findAll();
        return all;
    }

    @Transactional
    public void save(Order order){
        order.setOrderStatus(OrderStatus.ORDER);
        orderRepository.save(order);
    }
}
