package jjfactory.javathe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;
}
