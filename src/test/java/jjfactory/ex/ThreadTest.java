package jjfactory.ex;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadTest implements Runnable {


    @Override
    public void run() {
        log.info("run 실행");
    }

    @Test
    void runTest(){
        ThreadTest threadTest = new ThreadTest();
        threadTest.run();
    }
}
