package jjfactory.javathe.stream;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter @Setter
public class People {
    private String name;
    private int age;
    private int gender; // 1 - male

    public People(String name, int age, int gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public static List<People> getPeople(){
        return Arrays.asList(
                new People("lee",46,1),
                new People("kim",33,2),
                new People("ass",24,2)
        );
    }
}
