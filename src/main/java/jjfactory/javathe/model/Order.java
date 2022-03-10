package jjfactory.javathe.model;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
}
