package jjfactory.sample;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
public class Unit {
    @Id @GeneratedValue
    @Column(name = "unit_id")
    private Long id;

    private String name;
    private String password;

    public Unit() {
    }

    public Unit(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void changeName(String name){
        this.name = name;
    }
}
