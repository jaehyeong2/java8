package jjfactory.javathe.lambda;

@FunctionalInterface // 달아주면 추상 메소드 1개 초과하면 컴파일 에러남
public interface RunSomething {
    void doIt();
     // 함수형 인터페이스는 추상메소드가 하나
//    void doItAgain();

    static void printName(){
        System.out.println("hi!");
    }

}
