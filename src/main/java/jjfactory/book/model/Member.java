package jjfactory.book.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    private List<Order> orderList = new ArrayList<>();

    @Embedded
    private Address address;
}
