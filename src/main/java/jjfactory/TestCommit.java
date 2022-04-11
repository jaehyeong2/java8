package jjfactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestCommit {
    //커밋이 계속사라져!!
    void hi(){
        log.info("커밋 어디갔어!!");
    }
}
