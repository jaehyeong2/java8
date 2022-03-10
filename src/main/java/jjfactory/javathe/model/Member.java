package jjfactory.javathe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private Address address;

    public Member() {
    }

    public Member(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
