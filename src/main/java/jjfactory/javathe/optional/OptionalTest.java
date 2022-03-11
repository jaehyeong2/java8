package jjfactory.javathe.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalTest {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();

        springClasses.add(new OnlineClass(1, "spring boot",true));
        springClasses.add(new OnlineClass(2, "spring boot2",true));
        springClasses.add(new OnlineClass(3, "spring boot3",false));
        springClasses.add(new OnlineClass(4, "spring boot4",false));
        springClasses.add(new OnlineClass(5, "spring boot5",true));

        OnlineClass spring_boot = new OnlineClass(1,"spring boot",true);
//        Progress progress = spring_boot.getProgress().orElseThrow(() -> {
//            throw  new IllegalArgumentException("null");
//        });

        Optional<OnlineClass> spring = springClasses.stream().filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        Optional<OnlineClass> error1 = springClasses.stream().filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        OnlineClass onlineClass = spring.get();
        OnlineClass errorClass = error1.orElseThrow(()->{
            return new IllegalArgumentException("error~");
        });

        System.out.println("onlineClass = " + onlineClass.getTitle());
        System.out.println("errorClass = " + errorClass.getTitle());

        boolean present = spring.isPresent();
        System.out.println("present = " + present);
    }
}
