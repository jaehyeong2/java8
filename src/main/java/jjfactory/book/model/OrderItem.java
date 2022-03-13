package jjfactory.book.model;

import jjfactory.book.model.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    private int orderPrice;
    private int count;

    public static OrderItem createOrderItem(Item item,int orderPrice, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

//        item.removeStock(count);
        return orderItem;
    }

    public void add(OrderItem orderItem) {
        ????????
    }
}
