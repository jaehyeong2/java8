package jjfactory.javathe.lambda;

import java.util.function.Function;

public class Foo {
    public static void main(String[] args) {
//        RunSomething run = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("do it~");
//            }
//        };
        RunSomething runSomething = () -> {
            System.out.println("do it");
        };
        runSomething.doIt();
        run();
        Plus plus = new Plus();
        System.out.println(plus.apply(10));

        Function<Integer,Integer> add = (i) -> {
         return i +10;
        };

        Integer apply = add.apply(50);
        System.out.println(apply);
    }

    public static void run(){
        System.out.println("run!!");
    }
}


