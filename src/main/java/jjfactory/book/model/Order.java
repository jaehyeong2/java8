package jjfactory.book.model;

import jjfactory.book.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime orderDate;

    @ManyToOne
    private Member member;

    @OneToOne
    private Delivery delivery;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setOrderStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    private void addOrderItem(OrderItem orderItem) {
        orderItem.add(orderItem);
        orderItem.setOrder(this);
    }
}
